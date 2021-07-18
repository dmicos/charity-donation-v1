$(document).ready(function () {
    //Initialize tooltips
    $('.nav-tabs > li a[title]').tooltip();

    //Wizard
    $('a[data-toggle="tab"]').on('show.bs.tab', function (e) {
        var $target = $(e.target);
        if ($target.parent().hasClass('disabled')) {
            return false;
        }
    });

    $(".next-step").click(function () {
        var $active = $('.nav-tabs li>.active');
        var $step = $active.attr('aria-controls');
        if (validate($step)) {
            $active.parent().next().find('.nav-link').removeClass('disabled');
            nextTab($active);
        }
    });

    $(".prev-step").click(function () {
        var $active = $('.nav-tabs li>a.active');
        prevTab($active);
    });
});

function nextTab(elem) {
    $(elem).parent().next().find('a[data-toggle="tab"]').click();
    if ($('.nav-tabs li>.active').attr('aria-controls') === "complete") {
        summaryInfo()
    }
}

function prevTab(elem) {
    $(elem).parent().prev().find('a[data-toggle="tab"]').click();
}

// Getter for last step
function summaryInfo() {
    var categories = $('#step1 input:checked').parent().find('label').map(
        function () {
            return $.trim($(this).text())
        }).get();
    var quantity = $("#quantity").val();
    var institution = $('#step3 input:checked').parent().find('label').text();
    var street = $("#street").val();
    var city = $("#city").val();
    var zipcode = $("#zipcode").val();
    var date = $("#pickUpDate").val();
    var time = $("#pickUpTime").val();
    var pickUpComment = $("#pickUpComment").val();

    $('#quantity-info').text(quantity);
    $('#category-info').html(categories.join(";<br>"));
    $('#institution-info').text(institution);
    $('#street-info').text(street);
    $('#city-info').text(city);
    $('#zipcode-info').text(zipcode);
    $('#date-info').text(date);
    $('#time-info').text(time);
    $('#pickUpComment-info').text(pickUpComment);
}

function alertModal(text) {
    const modal = $('#modal');
    modal.find('.modal-body').html(text);
    modal.modal('show');
    return false;
}

// Simple form validation
function validate(step) {
    let $form = $("#donationForm");
    switch (step) {
        case 'step1':
            return $form.find('#step1 input:checked').length > 0 ? true : alertModal('Not mark');
        case 'step2':
            return $('#quantity').val() > 0 ? true : alertModal('Quantity is empty');
        case 'step3':
            return $form.find("#step3 input:checked").length > 0 ? true : alertModal('Not checked');
        case 'step4':
            var street = $('#street').val();
            var city = $('#city').val();
            var zipcode = $('#zipcode').val();
            var pickUpDate = $('#pickUpDate').val();
            var pickUpTime = $('#pickUpTime').val();
            var zipReg = new RegExp(/^[0-9]{2}(?:-[0-9]{3})?$/);
            var err = "";
            if (street < 1) {
                err = 'Street is empty <br>';
            }
            if (city < 1) {
                err = err + 'City is empty <br>';
            }
            if ((zipcode < 1)) {
                err = err + 'Zipcode is empty <br>';
            }
            if (!zipReg.test(zipcode)) {
                err = err + 'Zipcode must be in format: XX-XXX<br>';
            }
            if (pickUpDate < 1) {
                err = err + 'PickUpDate is empty <br>';
            }
            if (pickUpTime < 1) {
                err = err + 'PickUpTime is empty <br>';
            }
            if (err.length > 0) return alertModal(err);
            return true;
        default:
            return false;
    }
}




package farestartreporting;

import farestartreporting.responseModel.BusinessLocation;
import farestartreporting.responseModel.BusinessResponse;
import farestartreporting.responseModel.BusinessReport;
import farestartreporting.responseModel.GetDataInputPayload;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;

@RestController
public class getDataController {

    @RequestMapping( value = "/getData", method = RequestMethod.GET, produces = "application/json")
    public BusinessResponse getData() {

//        Date startDate = inputPayload.startDate;
//        Date endDate = inputPayload.endDate;
        

        ArrayList<BusinessReport> businessReports = new ArrayList<BusinessReport>();
        businessReports.add(generateDummyBusiness(new Date()));

        BusinessResponse businessResponse = new BusinessResponse();
        businessResponse.data = businessReports;

        return businessResponse;
    }

    private BusinessReport generateDummyBusiness(Date reportingDate) {
        BusinessReport dummyBusinessReport = new BusinessReport();
        dummyBusinessReport.date = reportingDate;
        dummyBusinessReport.locations.add(getDummyBusinessLocation("Seattle"));
        dummyBusinessReport.locations.add(getDummyBusinessLocation("LA"));
        dummyBusinessReport.locations.add(getDummyBusinessLocation("San Fran"));
        dummyBusinessReport.locations.add(getDummyBusinessLocation("New York"));
        dummyBusinessReport.locations.add(getDummyBusinessLocation("Paris"));

        return dummyBusinessReport;
    }

    private BusinessLocation getDummyBusinessLocation(String locationName)  {
        BusinessLocation dummyLocation = new BusinessLocation();
        dummyLocation.name = locationName;
        dummyLocation.budget = randomDouble(0.00, 10000.00);
        dummyLocation.netSales = randomDouble(0.00, 15000.00);
        dummyLocation.checkCount = randomLong(1, 2000);
        dummyLocation.guestCount = randomLong(2, 4000);

        return dummyLocation;
    }

    private double randomDouble(double min, double max) {
        return min + Math.random() * (max - min);
    }

    private Long randomLong(long min, long max) {
        return min + (long) (Math.random() * (max - min));
    }

    //JS Dates
    //Optinoal Budget
    //No sales & No guest = closed, return null for guestCount, checkCount and netSales (budget may be non-null)
    //
}
package Tests;
import Helpers.App;
import org.junit.After;
import org.junit.Before;

import java.io.File;

public abstract class BaseTest {
    App app = new App();

    @Before
    public void setTest() {
        File deleteFileProd = new File("actualProducts.txt");
        File deleteFileJob = new File("actualJobs.txt");
        File deleteFileResult = new File("actual/searchResult.csv");

        if (deleteFileProd != null && deleteFileJob != null && deleteFileResult != null) {
            app.common.appBefore();
            deleteFileProd.delete();
            deleteFileJob.delete();
            deleteFileResult.delete();
        }

        app.common.appBefore();
    }
    @After
    public void tearDown() {
        app.common.appOut();
    }
}

package Tests;

import org.junit.Assert;
import org.junit.Test;
import junitx.framework.FileAssert;

import java.io.File;
import java.io.IOException;

public class SearchTest extends BaseTest {

    @Test
    public void checkSearchResult() throws IOException {
        app.homePage.clickSearchButton();
        app.homePage.executeSearch("DEVELOPER");
        app.searchResultPage.getProductsFromSearch();
        app.searchResultPage.getJobsFromSearch();
        app.searchResultPage.mergeSearchResult();
        File expected = new File("expected/test.csv");
        File actual = new File("actual/searchResult.csv");
        FileAssert.assertBinaryEquals("The files are differ!", expected, actual);

    }
}

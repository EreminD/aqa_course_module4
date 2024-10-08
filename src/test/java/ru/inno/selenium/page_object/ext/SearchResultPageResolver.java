package ru.inno.selenium.page_object.ext;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.openqa.selenium.WebDriver;
import ru.inno.selenium.page_object.page.SearchResultPage;

public class SearchResultPageResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(SearchResultPage.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Object obj = extensionContext.getStore(MainPageResolver.namespace).get("driver");
        WebDriver driver = ((WebDriver) obj);

        return new SearchResultPage(driver);
    }
}
package repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SeleniumObj {
	
		public void selectByIndex(WebElement element,int index) {
			Select sel = new Select(element);
			sel.selectByIndex(index);
		}
		public void selectByvalue(WebElement element,String value) {
			Select sel = new Select(element);
			sel.selectByValue(value);
		}
		public void selectByText(WebElement element,String visibletext) {
			Select sel = new Select(element);
			sel.selectByVisibleText(visibletext);
		}
}

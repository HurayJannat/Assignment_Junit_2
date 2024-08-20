import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import javax.naming.ldap.Control;
import java.time.Duration;
import java.util.List;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyJunitTest {



    WebDriver driver;

    @BeforeAll
    public void setup()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

    }



    @Test
    public void myTest() throws InterruptedException {
        driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/");
        driver.findElement(By.id("first_name")).sendKeys("Huray");
        driver.findElement(By.id("last_name")).sendKeys("Jannat");
        driver.findElement(By.id("user_email")).sendKeys("ghjkbnm@gmail.com");
        driver.findElement(By.id("radio_1665627729_Female")).click();
        driver.findElement(By.id("user_pass")).sendKeys("!@asdfgYUIOLKJN456");

        //DateOfBirth
        WebElement birthDateInput = driver.findElement(By.cssSelector("input[data-id='date_box_1665628538']"));
        birthDateInput.click();
        WebElement birthDate = driver.findElement(By.xpath("//span[@class='flatpickr-day ' and @aria-label='August 1, 2024']"));
        birthDate.click();


        driver.findElement(By.id("input_box_1665629217")).sendKeys("Bangladeshi");
        driver.findElement(By.id("phone_1665627880")).click();


        //PhoneNumber
        List<WebElement> phoneNumbers = driver.findElements(By.id("phone_1665627880"));
        phoneNumbers.get(1).sendKeys("1234567890");



        //DropDown Country
        WebElement dropdown= driver.findElement(By.id("country_1665629257"));
        Select option = new Select(dropdown);
        option.selectByVisibleText("Bangladesh");


        //Emergency Contact
        List<WebElement>  emergencyContacts = driver.findElements(By.id("phone_1665627865"));
        emergencyContacts.get(1).sendKeys("0987654321");


        //Scroll
        Utils.scroll(driver,500);

        //DateOfArrival
        WebElement arrivalDateInput = driver.findElement(By.cssSelector("input[data-id='date_box_1665629845']"));
        arrivalDateInput.click();

        WebElement birthDate2 = driver.findElement(By.xpath("//span[@class='flatpickr-day ' and @aria-label='August 1, 2024']"));
        birthDate2.click();

        //Length of Stay
        driver.findElement(By.id("number_box_1665629930")).sendKeys("7");

        //Room and bed
        driver.findElement(By.id("input_box_1665630010")).sendKeys("2 4");

        //Occupation and PlaceOf Employment
        driver.findElement(By.id("textarea_1665630078")).sendKeys("SQA && Mohammadpur");

        //Parking
        driver.findElement(By.id("radio_1665627931_No")).click();


        //scroll
        Utils.scroll(driver,500);


        //Room Preference
        driver.findElement(By.id("radio_1665627997_Shared Room")).click();


        //Dietary
        driver.findElement(By.id("radio_1665628131_Lactose Allergy")).click();



        //scroll
        Utils.scroll(driver,500);


        //Activities
        WebElement activityDropdown = driver.findElement(By.id("select_1665628361"));
        Select activityOption = new Select(activityDropdown);
        activityOption.selectByVisibleText("Town Hall");



        //Terms && Conditions
        driver.findElement(By.id("privacy_policy_1665633140")).click();


        //Submit
        driver.findElement(By.className("btn")).click();



        WebElement successMessage = driver.findElement(By.id("ur-submit-message-node"));
        String messageActual = successMessage.getText();
        System.out.println(messageActual);

        String messageExpected ="User successfully registered.";














    }
}
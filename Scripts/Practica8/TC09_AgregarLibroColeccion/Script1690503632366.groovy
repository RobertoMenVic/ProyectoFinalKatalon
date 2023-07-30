import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String prjRoute = RunConfiguration.getProjectDir()

WebUI.callTestCase(findTestCase('Practica8/TC08_iniciarSesion'), [('userName') : 'menvic', ('password') : 'h1QkcHMxUvFccyXAlIpiJg=='], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/PRACTICA8/SUB_MENU/subMenu', [('subMenu') : 'Book Store']))

//Buscamos Libro y lo agregamos a la colección 
WebUI.sendKeys(findTestObject('Object Repository/PRACTICA8/BOOK_STORE/input_searchBox'), 'Elo')

WebUI.sendKeys(findTestObject('Object Repository/PRACTICA8/BOOK_STORE/input_searchBox'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/PRACTICA8/BOOK_STORE/a_libro'))

WebUI.click(findTestObject('Object Repository/PRACTICA8/BOOK_STORE/button_addToYourCollection'))

WebUI.acceptAlert(FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Object Repository/PRACTICA8/BOOK_STORE/button_addToYourCollection'), FailureHandling.OPTIONAL)

WebUI.acceptAlert(FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Object Repository/PRACTICA8/SUB_MENU/subMenu', [('subMenu') : 'Profile']))

WebUI.verifyElementVisible(findTestObject('Object Repository/PRACTICA8/BOOK_STORE/a_libro'))

WebUI.takeScreenshot(prjRoute + '\\Imagenes\\tc9.jpg', FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()
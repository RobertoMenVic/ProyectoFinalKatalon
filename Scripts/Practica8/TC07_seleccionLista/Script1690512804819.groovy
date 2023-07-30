import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
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

WebUI.openBrowser(GlobalVariable.URL_DEMOQA)

WebUI.maximizeWindow()

//Inicio Menú y subMenu 
WebUI.scrollToElement(findTestObject('Object Repository/PRACTICA1/Home/div_Elements'), 1)

WebUI.click(findTestObject('Object Repository/PRACTICA1/Home/div_Elements'))

WebUI.scrollToElement(findTestObject('Object Repository/PRACTICA8/MENU1/menu', [('menu') : 'Widgets']), 0)

WebUI.click(findTestObject('Object Repository/PRACTICA8/MENU1/menu', [('menu') : 'Widgets']))

WebUI.scrollToElement(findTestObject('Object Repository/PRACTICA8/SUB_MENU/subMenu', [('subMenu') : 'Select Menu']), 2)

WebUI.click(findTestObject('Object Repository/PRACTICA8/SUB_MENU/subMenu', [('subMenu') : 'Select Menu']))

//Fin 
//Validación de objetos select 
WebUI.click(findTestObject('Object Repository/PRACTICA7/input_value'))

WebUI.sendKeys(findTestObject('Object Repository/PRACTICA7/select_value'), 'A root option')

WebUI.sendKeys(findTestObject('Object Repository/PRACTICA7/select_value'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/PRACTICA7/input_selectOne'))

WebUI.sendKeys(findTestObject('Object Repository/PRACTICA7/select_one'), 'Prof')

WebUI.sendKeys(findTestObject('Object Repository/PRACTICA7/select_one'), Keys.chord(Keys.ENTER))

WebUI.scrollToElement(findTestObject('Object Repository/PRACTICA7/select_oldStyle'), 1)

WebUI.selectOptionByValue(findTestObject('Object Repository/PRACTICA7/select_oldStyle'), '7', false)

WebUI.click(findTestObject('Object Repository/PRACTICA7/input_multiSelect'))

WebUI.sendKeys(findTestObject('Object Repository/PRACTICA7/select_multiSelect'), 'Black')

WebUI.sendKeys(findTestObject('Object Repository/PRACTICA7/select_multiSelect'), Keys.chord(Keys.ENTER))

WebUI.sendKeys(findTestObject('Object Repository/PRACTICA7/select_multiSelect'), 'Blue')

WebUI.sendKeys(findTestObject('Object Repository/PRACTICA7/select_multiSelect'), Keys.chord(Keys.ENTER))

WebUI.sendKeys(findTestObject('Object Repository/PRACTICA7/select_multiSelect'), 'Red')

WebUI.sendKeys(findTestObject('Object Repository/PRACTICA7/select_multiSelect'), Keys.chord(Keys.ENTER))

WebUI.selectOptionByValue(findTestObject('Object Repository/PRACTICA7/select_standardMulti'), 'saab', false)

WebUI.takeScreenshot(prjRoute + '\\Imagenes\\tc7.jpg', FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()
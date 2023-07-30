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

WebUI.click(findTestObject('Object Repository/PRACTICA8/MENU1/menu', [('menu') : 'Elements']))

WebUI.scrollToElement(findTestObject('Object Repository/PRACTICA8/MENU1/menu', [('menu') : 'Alerts, Frame & Windows']), 
    0)

WebUI.click(findTestObject('Object Repository/PRACTICA8/MENU1/menu', [('menu') : 'Alerts, Frame & Windows']))

WebUI.click(findTestObject('Object Repository/PRACTICA8/SUB_MENU/subMenu', [('subMenu') : 'Browser Windows']))

//Fin 
//Validación nueva pestaña del mismo navegador
WebUI.click(findTestObject('Object Repository/PRACTICA6/BROWSER_WINDOWS/button_newTab'))

WebUI.switchToWindowIndex(1)

WebUI.verifyMatch(WebUI.getUrl(), 'https://demoqa.com/sample', false)

WebUI.verifyElementText(findTestObject('Object Repository/PRACTICA6/BROWSER_WINDOWS_SAMPLE/title_sampleHeading'), 'This is a sample page')

WebUI.takeScreenshot(prjRoute + '\\Imagenes\\tc61.jpg', FailureHandling.STOP_ON_FAILURE)

WebUI.closeWindowIndex(1)

WebUI.switchToWindowIndex(0)

//Validación de un nuevo navegador
WebUI.click(findTestObject('Object Repository/PRACTICA6/BROWSER_WINDOWS/button_newWindow'))

WebUI.switchToWindowIndex(1)

WebUI.maximizeWindow()

WebUI.verifyMatch(WebUI.getUrl(), 'https://demoqa.com/sample', false)

WebUI.verifyElementText(findTestObject('Object Repository/PRACTICA6/BROWSER_WINDOWS_SAMPLE/title_sampleHeading'), 'This is a sample page')

WebUI.takeScreenshot(prjRoute + '\\Imagenes\\tc62.jpg', FailureHandling.STOP_ON_FAILURE)

WebUI.closeWindowIndex(1)

WebUI.switchToWindowIndex(0)

WebUI.closeBrowser()
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

WebUI.openBrowser(GlobalVariable.URL_DEMOQA)

WebUI.maximizeWindow()
//Inicio Menu y subMenu
WebUI.scrollToElement(findTestObject('Object Repository/PRACTICA1/Home/div_Elements'), 1)

WebUI.click(findTestObject('Object Repository/PRACTICA1/Home/div_Elements'))

WebUI.click(findTestObject('Object Repository/PRACTICA8/MENU1/menu', [('menu') : 'Elements']))

WebUI.scrollToElement(findTestObject('Object Repository/PRACTICA8/SUB_MENU/subMenu', [('subMenu') : 'Dynamic Properties']), 
    2)

WebUI.click(findTestObject('Object Repository/PRACTICA8/SUB_MENU/subMenu', [('subMenu') : 'Dynamic Properties']))
//Fin 

//Validamos el color de objeto input atributo CSS
String colorText = WebUI.getCSSValue(findTestObject('Object Repository/PRACTICA1/DYNAMIC_PROPERTIS/button_colorChange'), 
    'color')

WebUI.verifyMatch(colorText, 'rgba(255, 255, 255, 1)', false)

//Validamos que el objeto no se encuentre presente
WebUI.verifyElementNotPresent(findTestObject('Object Repository/PRACTICA1/DYNAMIC_PROPERTIS/button_visibleAfter'), 2)

WebUI.delay(5)

//Validamos nuevamente el color de objeto input atributo CSS
colorText = WebUI.getCSSValue(findTestObject('Object Repository/PRACTICA1/DYNAMIC_PROPERTIS/button_colorChange'), 'color')

WebUI.verifyMatch(colorText, 'rgba(220, 53, 69, 1)', false)

WebUI.verifyElementPresent(findTestObject('Object Repository/PRACTICA1/DYNAMIC_PROPERTIS/button_visibleAfter'), 1)

WebUI.takeScreenshot(prjRoute + '\\Imagenes\\tc4.jpg', FailureHandling.STOP_ON_FAILURE)
WebUI.closeBrowser()
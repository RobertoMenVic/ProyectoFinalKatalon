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

WebUI.scrollToElement(findTestObject('Object Repository/PRACTICA8/SUB_MENU/subMenu', [('subMenu') : 'Web Tables']),2)

WebUI.click(findTestObject('Object Repository/PRACTICA8/SUB_MENU/subMenu', [('subMenu') : 'Web Tables']))
//Fin

//Buscamos empleado y editamos nombre, apellido y salario
WebUI.setText(findTestObject('Object Repository/PRACTICA2/WEB_TABLES/input_buscar'), GlobalVariable.BUSCAR_EMPL)

WebUI.click(findTestObject('Object Repository/PRACTICA2/WEB_TABLES/button_editar', [('firstName') : GlobalVariable.BUSCAR_EMPL]))

WebUI.setText(findTestObject('Object Repository/PRACTICA1/REGISTRAR_FORM/input_firstName'), firstName2)

WebUI.setText(findTestObject('Object Repository/PRACTICA1/REGISTRAR_FORM/input_lastName'), lastName2)

WebUI.setText(findTestObject('Object Repository/PRACTICA1/REGISTRAR_FORM/input_salary'), Salary2)

WebUI.click(findTestObject('Object Repository/PRACTICA1/REGISTRAR_FORM/button_submit'))

//Nuevamente buscamos empleado y validamos que se hayan generado los cambios 
WebUI.setText(findTestObject('Object Repository/PRACTICA2/WEB_TABLES/input_buscar'), lastName2)

WebUI.click(findTestObject('Object Repository/PRACTICA2/WEB_TABLES/button_editar', [('firstName') : firstName2]))

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/PRACTICA1/REGISTRAR_FORM/input_firstName'), 'value', 
    firstName2, 1)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/PRACTICA1/REGISTRAR_FORM/input_lastName'), 'value', 
    lastName2, 1)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/PRACTICA1/REGISTRAR_FORM/input_salary'), 'value', Salary2, 
    1)

WebUI.takeScreenshot(prjRoute + '\\Imagenes\\tc2.jpg', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/PRACTICA2/WEB_TABLES/button_closeForm'))

WebUI.delay(2)

WebUI.closeBrowser()
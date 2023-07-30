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

//Inicio de menu y submenu 
WebUI.scrollToElement(findTestObject('Object Repository/PRACTICA1/Home/div_Elements'), 1)

WebUI.click(findTestObject('Object Repository/PRACTICA1/Home/div_Elements'))

WebUI.click(findTestObject('Object Repository/PRACTICA8/MENU1/menu', [('menu') : 'Elements']))

WebUI.scrollToElement(findTestObject('Object Repository/PRACTICA8/SUB_MENU/subMenu', [('subMenu') : 'Web Tables']), 2)

WebUI.click(findTestObject('Object Repository/PRACTICA8/SUB_MENU/subMenu', [('subMenu') : 'Web Tables']))

//Fin 
//Registro de empleado
WebUI.click(findTestObject('Object Repository/PRACTICA1/WEB_TABLES/button_add'))

WebUI.setText(findTestObject('Object Repository/PRACTICA1/REGISTRAR_FORM/input_firstName'), firstName)

WebUI.setText(findTestObject('Object Repository/PRACTICA1/REGISTRAR_FORM/input_lastName'), lastName)

WebUI.setText(findTestObject('Object Repository/PRACTICA1/REGISTRAR_FORM/input_userEmail'), email)

WebUI.setText(findTestObject('Object Repository/PRACTICA1/REGISTRAR_FORM/input_age'), age)

WebUI.setText(findTestObject('Object Repository/PRACTICA1/REGISTRAR_FORM/input_salary'), salary)

WebUI.setText(findTestObject('Object Repository/PRACTICA1/REGISTRAR_FORM/input_department'), depart)

WebUI.click(findTestObject('Object Repository/PRACTICA1/REGISTRAR_FORM/button_submit'))

//Validamos que el empleado exista en la lista de empleados
WebUI.verifyElementText(findTestObject('Object Repository/PRACTICA1/WEB_TABLES/div_firstName', [('firstName') : firstName]), 
    firstName)

WebUI.takeScreenshot(prjRoute + '\\Imagenes\\tc1.jpg', FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()
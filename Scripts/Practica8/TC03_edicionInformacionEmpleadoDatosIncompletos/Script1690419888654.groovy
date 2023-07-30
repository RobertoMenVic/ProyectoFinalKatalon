import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String prjRoute = RunConfiguration.getProjectDir()

WebUI.openBrowser(GlobalVariable.URL_DEMOQA)

WebUI.maximizeWindow()

//Inicio de menu y sub menu
WebUI.scrollToElement(findTestObject('Object Repository/PRACTICA1/Home/div_Elements'), 1)

WebUI.click(findTestObject('Object Repository/PRACTICA1/Home/div_Elements'))

WebUI.click(findTestObject('Object Repository/PRACTICA8/MENU1/menu', [('menu') : 'Elements']))

WebUI.scrollToElement(findTestObject('Object Repository/PRACTICA8/SUB_MENU/subMenu', [('subMenu') : 'Web Tables']), 2)

WebUI.click(findTestObject('Object Repository/PRACTICA8/SUB_MENU/subMenu', [('subMenu') : 'Web Tables']))

//Fin 
//buscamos y consultamos empleado 
WebUI.setText(findTestObject('Object Repository/PRACTICA2/WEB_TABLES/input_buscar'), GlobalVariable.BUSCAR_EMPL)

WebUI.click(findTestObject('Object Repository/PRACTICA2/WEB_TABLES/button_editar', [('firstName') : GlobalVariable.BUSCAR_EMPL]))

//Extraemos el dato del atributo value de objeto input 
String firstNameL = WebUI.getAttribute(findTestObject('Object Repository/PRACTICA1/REGISTRAR_FORM/input_firstName'), 'value')

String lastNameL = WebUI.getAttribute(findTestObject('Object Repository/PRACTICA1/REGISTRAR_FORM/input_lastName'), 'value')

String salaryL = WebUI.getAttribute(findTestObject('Object Repository/PRACTICA1/REGISTRAR_FORM/input_salary'), 'value')

//Validamos que el dato del value sea el mismos que la variable
WebUI.verifyMatch(firstNameL, firstName, false)

WebUI.verifyMatch(lastNameL, lastName, false)

WebUI.verifyMatch(salaryL, salary, false)

WebUI.clearText(findTestObject('Object Repository/PRACTICA1/REGISTRAR_FORM/input_firstName'))

WebUI.click(findTestObject('Object Repository/PRACTICA1/REGISTRAR_FORM/button_submit'))

WebUI.delay(5)

//Validamos que el objeto tenga el atributo required
WebUI.verifyElementHasAttribute(findTestObject('Object Repository/PRACTICA1/REGISTRAR_FORM/input_firstName'), 'required', 
    1)

WebUI.verifyTextPresent('Registration Form', false)

WebUI.takeScreenshot(prjRoute + '\\Imagenes\\tc1.jpg', FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()
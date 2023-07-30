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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.awt.AWTException as AWTException
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvente
import java.awt.event.KeyEvent as KeyEvent

String prjRoute = RunConfiguration.getProjectDir()

WebUI.openBrowser(GlobalVariable.URL_DEMOQA)

WebUI.maximizeWindow()

//Inicio Menu y subMenu
WebUI.scrollToElement(findTestObject('Object Repository/PRACTICA1/Home/div_Elements'), 1)

WebUI.click(findTestObject('Object Repository/PRACTICA1/Home/div_Elements'))

WebUI.scrollToElement(findTestObject('Object Repository/PRACTICA8/MENU1/menu', [('menu') : 'Forms']), 0)

WebUI.click(findTestObject('Object Repository/PRACTICA8/MENU1/menu', [('menu') : 'Forms']))

WebUI.scrollToElement(findTestObject('Object Repository/PRACTICA8/SUB_MENU/subMenu', [('subMenu') : 'Practice Form']), 2)

WebUI.click(findTestObject('Object Repository/PRACTICA8/SUB_MENU/subMenu', [('subMenu') : 'Practice Form']))

//Fin 
//Agrega datos al formulario
WebUI.setText(findTestObject('Object Repository/PRACTICA5/PRACTICE_FORM/input_firstName'), firstName)

WebUI.setText(findTestObject('Object Repository/PRACTICA5/PRACTICE_FORM/input_lastName'), lastName)

WebUI.setText(findTestObject('Object Repository/PRACTICA5/PRACTICE_FORM/input_email'), email)

WebUI.click(findTestObject('Object Repository/PRACTICA5/PRACTICE_FORM/input_gender'))

WebUI.setText(findTestObject('Object Repository/PRACTICA5/PRACTICE_FORM/input_mobile'), mobile)

//WebUI.clearText(findTestObject('Object Repository/PRACTICA5/PRACTICE_FORM/input_date'))
//WebUI.sendKeys(findTestObject('Object Repository/PRACTICA5/PRACTICE_FORM/input_date'), Keys.chord(Keys.CONTROL, 'a'))
//WebUI.sendKeys(findTestObject('Object Repository/PRACTICA5/PRACTICE_FORM/input_date'), Keys.chord(Keys.BACK_SPACE))
//WebUI.setText(findTestObject('Object Repository/PRACTICA5/PRACTICE_FORM/input_date'), date)
WebUI.scrollToElement(findTestObject('Object Repository/PRACTICA5/PRACTICE_FORM/input_hobbies'), 1)

WebUI.click(findTestObject('Object Repository/PRACTICA5/PRACTICE_FORM/input_hobbies'))

WebUI.uploadFile(findTestObject('Object Repository/PRACTICA5/PRACTICE_FORM/input_selecconarArchivo'), 'C:\\Users\\JRobertoMV\\Downloads\\pruebaAcsel.png')

WebUI.setText(findTestObject('Object Repository/PRACTICA5/PRACTICE_FORM/input_currentAddress'), currentAddress)

//WebUI.executeJavaScript('document.body.style.zoom=\'50%\'', null)
//Se hace zoom a la pantalla del navegador 
//CustomKeywords.'AccionesNavegador.zoomOUt'(4)
Robot robot = new Robot()

for (int i = 0; i < 4; i++) {
    robot.keyPress(KeyEvent.VK_CONTROL)

    robot.keyPress(KeyEvent.VK_SUBTRACT)

    robot.keyRelease(KeyEvent.VK_SUBTRACT)

    robot.keyRelease(KeyEvent.VK_CONTROL)
}

//Hacemos click en botón submmit
WebUI.sendKeys(findTestObject('Object Repository/PRACTICA5/PRACTICE_FORM/button_submit'), Keys.chord(Keys.ENTER))

WebUI.verifyElementText(findTestObject('Object Repository/PRACTICA5/MODAL/div_modal'), 'Thanks for submitting the form')

WebUI.takeScreenshot(prjRoute + '\\Imagenes\\tc5.jpg', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/PRACTICA5/MODAL/button_clase'))

WebUI.closeBrowser()
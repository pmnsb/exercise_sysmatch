import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
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
import com.GlobalVariableUpdater as GlobalVariableUpdater
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import groovy.json.JsonSlurper as JsonSlurper

ResponseObject resposta = WS.sendRequest(findTestObject('Resources/Delete_User'))

// Obter o conteúdo da resposta como uma string JSON
String responseBody = resposta.getResponseBodyContent()

print(responseBody)

// Obter o código de status da resposta
int codigoStatus = resposta.getStatusCode()
println codigoStatus
// Assert para verificar se o código de status é 204
assert codigoStatus == 204
println("User removido com sucesso!: $codigoStatus")


User_Status = 'Deleted'
GlobalVariableUpdater.updatePermanently(RunConfiguration.getExecutionProfile(), 'status', User_Status)


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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import groovy.json.JsonSlurper

ResponseObject resposta = WS.sendRequest(findTestObject('Nested_Resources/Get_User_Post'))

// Obter o conteúdo da resposta como uma string JSON
String responseBody = resposta.getResponseBodyContent()

print(responseBody)

// Obter o código de status da resposta
int codigoStatus = resposta.getStatusCode()

println(codigoStatus)

// Assert para verificar se o código de status é 200 (Criado)
assert codigoStatus == 200

println("Solicitação bem-sucedida! Código de status: $codigoStatus")

// Remover os parênteses retos da resposta JSON
def respostaSemParentes = responseBody.substring(1, responseBody.length() - 1)

// Criar um objeto JsonSlurper para analisar a string JSON
JsonSlurper slurper = new JsonSlurper()

def jsonResposta = slurper.parseText(respostaSemParentes)

// Assert para verificar se o id na resposta corresponde à GlobalVariable 'id'
assert jsonResposta.id.toString() == GlobalVariable.Id_Post
println jsonResposta.id
// Assert para verificar se o title na resposta corresponde à GlobalVariable 'title'
assert jsonResposta.title == GlobalVariable.title_Post
print jsonResposta.title
// Assert para verificar se o body na resposta corresponde à GlobalVariable 'body'
assert jsonResposta.body == GlobalVariable.body_Post
print jsonResposta.body
println("Asserts bem-sucedidos para as GlobalVariables 'id', 'title' e 'body'")

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

// Enviar a requisição e obter a resposta
ResponseObject resposta = WS.sendRequest(findTestObject('Resources/Update_User', [('name') : GlobalVariable.new_name, ('email') : GlobalVariable.email, ('gender') : GlobalVariable.gender
            , ('status') : GlobalVariable.status]))

// Obter o conteúdo da resposta como uma string JSON
String responseBody = resposta.getResponseBodyContent()

print(responseBody)

// Obter o código de status da resposta
int codigoStatus1 = resposta.getStatusCode()
println codigoStatus1
// Assert para verificar se o código de status é 200 (Criado)
assert codigoStatus1 == 200
println("Solicitação bem-sucedida! Código de status: $codigoStatus1")

// Enviar a requisição e obter a resposta
ResponseObject resposta1 = WS.sendRequest(findTestObject('Resources/Get_User'))

// Obter o conteúdo da resposta como uma string JSON
String responseBody1 = resposta1.getResponseBodyContent()

print(responseBody1)

// Obter o código de status da resposta
int codigoStatus = resposta1.getStatusCode()
println codigoStatus
// Assert para verificar se o código de status é 201 (Criado)
assert codigoStatus == 200
println("Solicitação bem-sucedida! Código de status: $codigoStatus")

// Criar um objeto JsonSlurper para analisar a string JSON
JsonSlurper slurper = new JsonSlurper()

def jsonResposta = slurper.parseText(responseBody)

// Definir os valores esperados
def expectedName = GlobalVariable.new_name

println('expectedName = ' + expectedName)

def expectedEmail = GlobalVariable.email

println('expectedEmail = ' + expectedEmail)

def expectedGender = GlobalVariable.gender

println('expectedGender = ' + expectedGender)

def expectedStatus = GlobalVariable.status

println('expectedStatus = ' + expectedStatus)

// Comparar os campos da resposta com os valores esperados
assert jsonResposta.name == expectedName : 'Campo \'name\' não corresponde ao esperado.'

assert jsonResposta.email == expectedEmail : 'Campo \'email\' não corresponde ao esperado.'

assert jsonResposta.gender == expectedGender : 'Campo \'gender\' não corresponde ao esperado.'

assert jsonResposta.status == expectedStatus : 'Campo \'status\' não corresponde ao esperado.'

// Se todas as comparações passarem, significa que os campos na resposta são iguais aos valores esperados
println('Todos os campos na resposta correspondem aos valores esperados.')




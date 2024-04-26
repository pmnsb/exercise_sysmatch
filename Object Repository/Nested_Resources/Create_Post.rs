<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Create_Post</name>
   <tag></tag>
   <elementGuidId>7709d9ae-6a19-47e3-bf05-06b0df79a656</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <authorizationRequest>
      <authorizationInfo>
         <entry>
            <key>bearerToken</key>
            <value>fb7d8ad1c10b0f511b2901777319e79d522b1771fbc84cff79e7abe6dffa32d5</value>
         </entry>
      </authorizationInfo>
      <authorizationType>Bearer</authorizationType>
   </authorizationRequest>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;post\&quot;: \&quot;${Id_Post}\&quot;,\n  \&quot;title\&quot;: \&quot;${title}\&quot;,\n  \&quot;body\&quot;: \&quot;${body_Post}\&quot;\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>eb1fb839-b756-4259-b3c5-17b451bbb759</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer fb7d8ad1c10b0f511b2901777319e79d522b1771fbc84cff79e7abe6dffa32d5</value>
      <webElementGuid>ba1ce323-a9dc-45ba-956e-580610e6596d</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.6.8</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://gorest.co.in/public/v2/users/${GlobalVariable.Id_User}/posts</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>GlobalVariable.Id_Post</defaultValue>
      <description></description>
      <id>e07f70d9-ac83-4eca-ac86-874e9063bfed</id>
      <masked>false</masked>
      <name>Id_Post</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.body_Post</defaultValue>
      <description></description>
      <id>8c151258-8fb1-4960-91e9-0678161d4ea6</id>
      <masked>false</masked>
      <name>body_Post</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.title_Post</defaultValue>
      <description></description>
      <id>98e4ecd5-a1c1-4dac-816c-768b944ee9bf</id>
      <masked>false</masked>
      <name>title</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

# SmsProvider
Framework: Spring Boot (v2.7.1)<br>
Dependencies: Freemarker, Validation, Web, Lombok


Api:<br>
/api/send: send message to client side for processing<br>
Body Example: {"phone":"0383738329","content":"hello","type":"VMGS"}

Solution:<br>
Use Strategy Pattern<br>
+Context: MessageSender<br>
+Strategy: SendingMethod<br>
+ConcreteStrategy: <ProviderName>SendingMethod<br>

Use java reflection to initialize the corresponding instance provider method (method createSendingMethod(String type) in SmsSender)
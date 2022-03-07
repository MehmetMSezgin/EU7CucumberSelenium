$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Contacs.feature");
formatter.feature({
  "name": "Contacts page",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Contacts test with email",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@db"
    },
    {
      "name": "@Database"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user logged in as \"sales manager\"",
  "keyword": "Given "
});
formatter.match({
  "location": "com.vytrack.step_definitions.ContactsStepDef.the_user_logged_in_as(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user navigates to \"Customers\" \"Contacts\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.vytrack.step_definitions.NavigationMenuStepDefs.theUserNavigatesTo(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks the \"mbrackstone9@example.com\" from contacts",
  "keyword": "When "
});
formatter.match({
  "location": "com.vytrack.step_definitions.ContactsStepDef.the_user_clicks_the_from_contacts(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "information should ben same with database",
  "keyword": "Then "
});
formatter.match({
  "location": "com.vytrack.step_definitions.ContactsStepDef.information_should_ben_same_with_database()"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\r\n\tat com.vytrack.utilities.DBUtils.executeQuery(DBUtils.java:167)\r\n\tat com.vytrack.utilities.DBUtils.getQueryResultMap(DBUtils.java:126)\r\n\tat com.vytrack.utilities.DBUtils.getRowMap(DBUtils.java:70)\r\n\tat com.vytrack.step_definitions.ContactsStepDef.information_should_ben_same_with_database(ContactsStepDef.java:99)\r\n\tat ✽.information should ben same with database(file:///C:/Users/Mehme/IdeaProjects/EU7CucumberSelenium/src/test/resources/features/Contacs.feature:70)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png", "screenshot");
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});
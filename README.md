jenkinsPlugin
=============

Learn how to dev jenkins plugin

#Add side panel action
just need to add sidepanel.jelly in corresponding folder of the action in resource folder 
You can add more code like "doDynamic" to handle click on this action. Or you can implements StaplerProxy interface in the action(only one getTarget() method). The return value could be an instance of one of your class, and you can add an jelly file for your class to response the request.

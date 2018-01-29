# Perfecto Customization Script Service - Code Sample

The following script demonstrates how to use Perfecto's DesktopWeb Customization Script capability to install an **ssl certificate**.

To learn more about the DesktopWeb Customization Script Service [click here](http://developers.perfectomobile.com/pages/viewpage.action?spaceKey=PD&title=Desktop-Web+Customization+Service).

## Getting Started:
- Clone the project `git clone https://github.com/PerfectoCode/DesktopWebCustomizationScript.git`
- Fill in you Perfecto Lab URL - in the URL variable (line #38 of the _CostumizationScriptSample.java_ file)
- Provide your security token for the _securityToken_ capability (line #27 of the java file)
- Run the project  

## SSL-Certificates
The sample uses the following site: https://self-signed.badssl.com/ <br/>
- Before installing the certificates:<br/>
    ![alt text](/img/not_secured.png) 
- After installing the certificates:<br/>
    ![alt text](/img/after_1.png)
    
    The connection is now considered **_secured_** by the browser:<br/>
    ![alt text](/img/secured.png) 

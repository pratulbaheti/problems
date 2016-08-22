# Feature Toggles

#### Background
Every customer is eligible for certain features which are used by DDC to decide customer's functionality.  
Features can be at:
- Control plane level: Feature in this category applies to all the customer in control plane eg SICP1, Production.
- Edition level: Feature in this category applies to all the customer having same licensing eg Platinum, AzureVDI etc.
- Customer level: Featues in this level are specific to customer.  

All customers are eligible for control plane level features. Edition level features are related to the licensing of the customer. The effective features for customer is merged set of all these features where customer level features take priority over edition level which inturn takes priority over control plane features.  
Each features can have different settings or values which decides characteristics of customer. Settings are case sensitive and values must be string eg {Enabled : "True/False"}.

#### Functionality
Obelisk has mechanism to Enable, Disable or apply default setting for customers. For eg, a feature name "GoogleAnalytics" is enabled at control plane level implies it is eligible for all the customers on that control plane level. If customer has "AzureVDI" licensing and corresponds to "AzureVDI" edition, which inturn has "Enabled: 'False" the effective setting will be false.  
Search for the customer and open its description page. Follow steps as shown in image.
![Fig 1. Customer Page](./customer_desc.png)

To check all the eligible features, please follow steps 1 and 2 as shown in image:
![Fig 1. All features for customer](./feature_toggle.png)

To change the values, use step 1 in above image

#### Usage
- Values in the dropdown are possible values for the corresponding feature. 
- Choosing Enable/Disable will create or modify settings at customer level which will override lower level settings. 
- Selecting "Default" value will remove the entries from the customer level features and default values which are either at control or edition level will be applied on customer.


#### Details required for a new feature.
- To create a new feature, raise ticket by mailing XD-Cloud-DevOps-Support@citrix.com
- Provide details for properties as featureId, feature colloquial name which appears on Obelisk, Enabled (True if feature is On and false if Off), additional property_keys and corresponding property_values.
- To add canary settings, provide new details same as above. After feature is rolled out completely these values will replace the default values of the feature.
- The new feature will be reflected on Obelisk in less than 1 minute and generally 30 seconds on DDC. No restart or reboot is required.

#### Add new Feature (For DevOps Team)
Features can be added at Control Plane level, Edition Level or Customer Level.

| | Control Plane: Add New Feature in DataStore |  
|----|:----|
| **URL**     | /controlplanes/{control_plane_id}/features/{feature_id}
| **Value**   | { 'Enabled' : "True"/"False", "__displayName" : "Feature Name",  "property_key1" : "property_value1" } 


| | Control Plane: Add New Canary Settings in DataStore |  
|----|:----|
| **URL**     | /controlplanes/{control_plane_id}/features/{feature_id}/canary
| **Value** | { 'stage' : 'testing', 'percentage' : 30, 'settings' = { 'Enabled' : "True"/"False", "__displayName" : "Feature Name",  "property_key1" : "property_value1" }} 


| | Edition Plane: Add New Feature in DataStore |  
|----|:----|
| **URL**     | /controlplanes/{control_plane_id}/editions/{edition_id}/{feature_id}
| **Value** | { 'Enabled' : "True"/"False", "__displayName" : "Feature Name",  "property_key1" : "property_value1" } 


| | Edition Plane: Add New Canary Settings in DataStore |  
|----|:----|
| **URL**     | /controlplanes/{control_plane_id}/editions/{edition_id}/{feature_id}/canary |
| **Value** | { 'stage' : 'testing', 'percentage' : 30, 'settings' = { 'Enabled' : "True"/"False", "__displayName" : "Feature Name",  "property_key1" : "property_value1" }} 


| | Customer Level : Add New Feature in DataStore |  
|----|:----|
| **URL**     | /controlplanes/{control_plane_id}/customers/{customer_id}/features/{feature_id}
| **Value** | { 'Enabled' : "True"/"False", "__displayName" : "Feature Name",  "property_key1" : "property_value1" } 


_**Note**_: In Future, features can be added through scripts provided to devops. For canary settings, Obelisk will have a page to add and update canary settings.


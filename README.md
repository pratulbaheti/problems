# Feature Toggles

#### Background
Features can be at control plane level, edition level and customer level. All customers are eligible for control plane level features. Edition level features are related to the licensing of the customer. The effective features for customer is merged set of all these features where customer features take priority over edition level which inturn takes priority over control plane features.
Each features have some settings and '''Enabled : "True/False" ''' setting is must for every feature, its case sensitive and value "True/False" is a string.

#### Functionality
Each customer is eligible for certain features. Users for Obelisk has mechanism to Enable, Disable or apply default setting for customers. For eg, a feature name "GoogleAnalytics" is enabled at control plane level implies it is eligible for all the customers on that control plane level. If customer has "AzureVDI" licensing and corresponds to "AzureVDI" edition, which inturn has "Enabled: 'False" the effective setting will be false.

#### Usage
Value in the dropdown below Feature are possible values for the feature. Choosing Enable/Disable will create or modify settings at customer level which will override lower level settings. Selecting "Default" value will remove the entries from the customer level features and default values which are either at control or edition level will be applied on customer.

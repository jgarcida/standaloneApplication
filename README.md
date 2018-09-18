# standaloneApplication
In this example i write code with java and i used json-simple api. This example it's about save user information then get information through id an then i show all user in a list.

After download de project is necesary to follow the next steps:										
    1.- Open eclipse
    2.- Click File > Import
    3.- Type Maven in the search box under Select an import source:
    4.- Select Existing Maven Projects
    5.- Click Next
    6.- Click Browse and select the folder that is the root of the Maven project.
    7.- Click Next
    8.- Click Finish
    
    Explanation about data base.
        For this example i going to use a relational database.
    
    I describing the tables and columns 
        I will describe the tables and columns, for this example is necesary 2 table then 
        one table for users and other for transaction where this tables join
        through id_user.
        
        *****TABLES*****
            USER
                COLUMNS
                user_id(pk)
                name
                last_name
                
            TRANSACTIONS
                COLUMNS
                id_transaction(pk)
                amount
                description
                user_id(fk)

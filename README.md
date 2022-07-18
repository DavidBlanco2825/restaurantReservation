# Restaurant Booking REST Service

This is a demo project in which a simple Spring REST service is implemented to manage the table booking for a small restaurant. 

>The REST service shows the available tables, reservation of tables, the cancellation of reservations and the statics of the restaurant.

### Available seats

The /tables endpoint handles GET request and return information about the restaurant.
The response information contains total tables and the available tables, 
each available table has table number and number of seat as properties, 
the response is a JSON object has the following format.

    {
        "totalTables": 6,
        "availableTables": [
            {
                "tableNumber": 1,
                "numberOfSeats": 6
            },
    
            - - -
    
            {
                "tableNumber": 6,
                "numberOfSeats": 4
            }
        ]
    }

In this example the restaurant has 6 tables, the number of seats is determined by a number of table.
If the number is odd, the number of seats is set to 6, 
if the number is even the number of seats is set to 4.


### Reservation

The /purchase endpoint handles POST request and marks a table as reserved. 
The request should contain tableNumber variable that correspond to the number of the table.

Example of a correct request body.

    {
        "tableNumber": 2
    }

The tableNumber is checked if the specified table is available. If available, the table is marked as
reserved and is taking down from the available tables.

The response information is a JSON object that has the following format.

    {
        "token": "ce598cb2-4d74-4973-b477-06fc737e4e64",
        "table": {
            "tableNumber": 1,
            "numberOfSeats": 6
        }
    }
Where token is the unique identifier of the table reservation, and table contains the table number and 
number of seats of the reserved table. 
>The token is generated using the randomUUID() method of the UUID class

If the table is already reserved, the response body is follows, with a response code 400.

    {
        "error": "The table has been already reserved."
    }

If the user pass a wrong table number, the response body is follows, with a response code 400.

    {
        "error": "The table number is out of bounds!."
    }

### Cancellation of reservation 

The /return endpoint handles POST request, undo a previous table reservation. 
The request body should have the token that identifies the table reservation, 
with the return token the table it relates to is identified and is marked as available.

The request body is as follows:

    {
        "token": "ce598cb2-4d74-4973-b477-06fc737e4e64"
    }

If the token is correct the response body is as follows:

    {
        "returnedTable": {
            "tableNumber": 1,
            "numberOfSeats": 6
        }
    }

response body with an expired token

    {
        "error": ""Wrong token!""
    }


### Restaurant statistics

The /stats endpoint handles POST request with URL parameters.

If the URL parameters contains a "password" key with a "secret_password" value, return the restaurant statistics in the following format:

    {
        "numberOfAvailableTables": 6
    }

If the parameters don't contain a password key or a wrong value has been passed, the respond body contains the following with a 401 status code.
    
    {
        "error": "The password is wrong!"
    }
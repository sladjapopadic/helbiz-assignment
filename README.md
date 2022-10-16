# Witness reports

REST api for storing witness reports

## Instructions
Reports can be created by providing name of the case and phone number of the witness to the following url:
http://localhost:8080/reports using the POST method.

The client should provide a body with the following properties: 

- **name** is the name of the case the witness is reporting,
- **phoneNumber** is the phone number of the witness reporting the case.

Example:

`{
    "name": "John Doe",
    "phoneNumber": "+381695365131"
}`

## Storing the reports
If the data provided is valid, it will be stored in the file `reports.txt` which is located at the root of the project.

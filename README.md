# THIS CODE WAS PART OF AN TECHNICAL INTERVIEW PROCESS

# ValidityChecker
A simple maven project that checks if some candidate data is valid or not, given some validity checks. In this small example, the ValidityChecker have the implementations of two checks: IsNotNull and IsSocialSecurityNumber.  

The framework of the ValidityChecker allows for easy implementations of new ValidityChecks through the ValidityCheck interface, which can then be added to the ValidityChecker to create a series of checks for some candidate data.

## Tests
To run the test for each implemented `ValidityCheck` is done through maven test.

`mvn clean test`


## How to use
Create an `ValidityChecker` object and give it a path to were to save the results.  

Create `ValidityCheck` objects for each check that is desired and add them to the `ValidityChecker`.  

Run the `ValidityChecker` using the `run()` method and some `CandidateData` object. The data used in the `run()` method can either be a single `CandidateData` object or a list of `CandidateData` objects. 

## Example

`CandidateData<Long> data = new CandidateData<Long>(197802022389L);`  

`ValidityChecker checker = new ValidityChecker("results");`  
`checker.addCheck(new IsNotNull());`  
`checker.addCheck(new IsSocialSecurityNumber());`  
`checker.run(data);`  

The output would be:  
`CandidateDataID: 326866b1-cfc6-4ad0-b8fa-0db2e2b3d664`  
`IsNotNull Check: PASSED`  
`IsSocialSecurityNumber Check: PASSED`  

Where `CandidateDataID` is an identifier given to the data by the `CandidateData` class. (No real use case now, but can be in future applications)

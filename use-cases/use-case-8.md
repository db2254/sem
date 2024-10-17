# USE CASE: 8 As an HR advisor I want to delete an employee's details so that the company is compliant with data retention legislation.

## CHARACTERISTIC INFORMATION

### Goal in Context
As an *HR advisor* I want *to delete an employee's details so that the company is compliant with data retention legislation.*
### Scope

Company.

### Level

Primary task.

### Preconditions
1. The employees details are stored in the database
2. HR has functionality to delete employee data
### Success End Condition

The employee's details are deleted from the system, and the company remains compliant with data retention laws.

### Failed End Condition

The employees details are not deleted which wouldn't comply with data retention laws.

### Primary Actor

HR Advisor.

### Trigger

A request is made to delete the employee's details.

## MAIN SUCCESS SCENARIO

1. The system identifies that the employee's retention period has expired, or the HR advisor receives a deletion request
2. The HR advisor accesses the system to locate the employee's details.
3. The HR advisor verifies the details of the employee to confirm for deletion.
4. The HR advisor deletes the employee's details from the system.
5. The system confirms deletion of the employee's data.
6. The HR advisor notifies relevant departments of the data deletion.

## EXTENSIONS

3. *Employee details cannot be found:*
    1. The HR advisor is informed that the employee's details do not exist.
4. *Deletion process fails:*
    1. The system has an error during the deletion process.
   2. The HR advisor attempts deletion again or contacts IT for technical support.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0

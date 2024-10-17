# USE CASE: 7 As an HR advisor I want to update an employee's details so that employee's details are kept up-to-date

## CHARACTERISTIC INFORMATION

### Goal in Context
As an HR advisor I want to update an employee's details so that the employee's details are kept up-to-date.
### Scope

Company.

### Level

Primary task.

### Preconditions
1. The employee’s details are stored in the HR system.
2. The HR advisor has access to the system and permission to update employee information.
3. The updated information is available.
### Success End Condition

The employee's details are updated in the system.
### Failed End Condition

The employee's details are not updated or the system rejects the updates.
### Primary Actor

HR Advisor.

### Trigger

A change in the employee's details is communicated to HR, or HR identifies outdated information
## MAIN SUCCESS SCENARIO

1. The HR advisor receives a request to update an employee's details
2. HR advisor accesses the HR system to retrieve the employee’s current details.
3. HR advisor updates the relevant information
4. The HR system updates and saves the changes.
5. HR advisor confirms the update and informs relevant departments

## EXTENSIONS

1. *System rejects the update:*
   1. The system identifies invalid or incomplete information.
   2. HR advisor corrects the data and attempts the update again.
2. *Employee details cannot be found:*
   1. The HR advisor is unable to locate the employee in the system.
   2. HR advisor contacts IT

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0

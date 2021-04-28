#Gitflow

###The order of working with branches:
The master branch contains up-to-date code that has been tested and is ready to go.
The feature / * and bugfix / * branches contain the implementation of new features in the system or fixes for existing bugs, respectively.

###How to work with pull requests:
A merge is possible only when receiving at least one confirmation from one of the repository owners.
Merging is possible only when all tests are passed (if any are required from the project developers)

###Merge policy: squash, fast-forward-only.
Squash allows you to maintain a cleaner master branch, fast-forward only allows merging after rebasing to the last commit in master, which forces you to always integrate the latest changes from master.
Work with rebase to solve conflicts.

###Additional policies:
It is forbidden to push directly to the master branch.
The commits should follow the simplified convention on top of the commit messages. (https://www.conventionalcommits.org/en/v1.0.0/)

Each commit and pull request headers must contain the corresponding issue numbers.
The description of the pull request must contain a textual description of the changes.

###The order of work with releases:
A project release is indicated by a tag in the semantic versioning format https://semver.org/
If you need to release fixes for a release without making the latest changes from the master branch, a branch is created with
name in the release / v1.1 format, which changes are made through pull requests. The number of discharges depends on the specific case:
If there is a need to maintain a branch in which development will be carried out in parallel with the main one and / or
integration of features for an outdated release, and the version numbers will change like v2.1.0 v2.2.0 v2.2.1 and so on, then the branch
should be called release / v2.0
If you only need to make patches, then the branch should be called release / v2.1 with version numbers v2.1.0 v.2.1.1, etc.
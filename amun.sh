#!/bin/bash

RED='\033[0;31m'
GREEN='\033[0;32m'
NC='\033[0m'
SUCCESS="${GREEN}SUCCESS:${NC}"
ERROR="${RED}ERROR:${NC}"
LINE="####################################################################"

#workshop starting point
startingBranch="ch1.0"

function start_message {
	echo "$LINE"
	echo -e "\n${SUCCESS}: $workshopBranch created"
	echo -e "${SUCCESS}: Workshop started, have fun!\n"
	echo "$LINE"
}

function error_start_message {
	echo "$LINE"
    echo -e "\n${ERROR}: Please provide one of next arguments\n"
	echo "$LINE"
}

function complete_message {
	echo "$LINE"
    echo -e "\n${GREEN}Workshop completed: congratulations!${NC}\n"
	echo "$LINE"
}


function next_stage_message {
	echo "$LINE"
    echo -e "\n${SUCCESS}: Moved to next stage\n"
	echo "$LINE"
}

function start_workshop {
	numberOfCommits=$(git rev-list --count $startingBranch)
	echo $(($numberOfCommits + 1)) > stage.amun
	
	git checkout $startingBranch

	workshopBranch="workshop-$RANDOM"
	git checkout -b $workshopBranch
	
	start_message
}

function next_stage {
	numberOfCommits=$(git rev-list --count master)
	status=$(($(cat stage.amun)))
	commitNumber=$(($numberOfCommits - $status))
	
	if [[ $commitNumber < 0 ]] ; then
		complete_message
		exit 1
	fi

	commits=$(git log master --pretty=oneline | tr -s ' ' | cut -d ' ' -f 1)
	
	SAVEIFS=$IFS   # Save current IFS
	IFS=$'\n'      # Change IFS to new line
	names=($commits) # split to array $names
	IFS=$SAVEIFS   # Restore IFS

	git cherry-pick ${names[$commitNumber]} --strategy-option theirs

	echo $(($status + 1)) > stage.amun
	next_stage_message
	exit 1
}

#main function
if [[ $# -eq 0 ]] ; then
	error_start_message
    exit 1
fi

if [[ $1 == 'start' ]] ; then
	start_workshop
	exit 1
elif [[ $1 == 'next' ]]; then
	next_stage
fi



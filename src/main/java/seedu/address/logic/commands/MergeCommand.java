package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE_OF_BIRTH;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MERGE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NRIC;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_POLICY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import seedu.address.logic.commands.exceptions.DuplicatePersonException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;

/**
 * Adds a person to the address book.
 */
public class MergeCommand extends Command {

    public static final String COMMAND_WORD = "merge";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Merges a duplicate profile. "
            + "Parameters: "
            + "DECISION "
            + "Example: " + "yes";

    public static final String MESSAGE_SUCCESS = "This profile has been updated to: %1$s";

    public Person personToMerge;

    /**
     * Creates an AddCommand to add the specified {@code Person}
     */
    public MergeCommand(Person personToMerge) {
        requireNonNull(personToMerge);
        this.personToMerge = personToMerge;
    }

    public MergeCommand() {
    }

    @Override
    public CommandResult execute(Model model) throws DuplicatePersonException {
        requireNonNull(model);
        /*
        Person originalPerson = model.getPerson(personToMerge);
        boolean hasDifferentPhone = !originalPerson.getPhone().value.equals(personToMerge.getPhone().value);
        boolean hasDifferentEmail = !originalPerson.getEmail().value.equals(personToMerge.getEmail().value);
        boolean hasDifferentAddress = !originalPerson.getAddress().value.equals(personToMerge.getAddress().value);
        boolean hasDifferentDateOfBirth = !originalPerson.getDateOfBirth().value
                .equals(personToMerge.getDateOfBirth().value);
        boolean hasDifferentPolicies = !originalPerson.getPolicies().equals(personToMerge.getPolicies());
        boolean hasDifferent
         */
        return new CommandResult(String.format(MESSAGE_SUCCESS, personToMerge));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof MergeCommand // instanceof handles nulls
                && personToMerge.equals(((MergeCommand) other).personToMerge));
    }
}

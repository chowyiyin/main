package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_COVERAGE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CRITERIA;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE_OF_BIRTH;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_END_AGE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_GENDER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NRIC;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_POLICY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PRICE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_START_AGE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.person.Person;
import seedu.address.model.policy.Policy;
import seedu.address.model.policy.PolicyNameContainsKeywordsPredicate;
import seedu.address.testutil.EditPersonDescriptorBuilder;

/**
 * Contains helper methods for testing commands.
 */
public class CommandTestUtil {

    public static final String VALID_NAME_AMY = "Amy Bee";
    public static final String VALID_NAME_BOB = "Bob Choo";
    public static final String VALID_NAME_DAVID = "David Georgia";
    public static final String VALID_NAME_LINCOLN = "Lincoln Feathers";
    public static final String VALID_NAME_KASSANDRA = "Kassandra Pearl";

    public static final String VALID_NRIC_AMY = "S0019283A";
    public static final String VALID_NRIC_BOB = "S0102939B";
    public static final String VALID_NRIC_DAVID = "S0000010T";
    public static final String VALID_NRIC_LINCOLN = "S0000011T";
    public static final String VALID_NRIC_KASSANDRA = "S0000012T";

    public static final String VALID_PHONE_AMY = "91111111";
    public static final String VALID_PHONE_BOB = "82222222";
    public static final String VALID_PHONE_DAVID = "94820001";
    public static final String VALID_PHONE_LINCOLN = "94820002";
    public static final String VALID_PHONE_KASSANDRA = "94820003";

    public static final String VALID_EMAIL_AMY = "amy@example.com";
    public static final String VALID_EMAIL_BOB = "bob@example.com";
    public static final String VALID_EMAIL_DAVID = "davegeorge@example.com";
    public static final String VALID_EMAIL_LINCOLN = "lincfeats@example.com";
    public static final String VALID_EMAIL_KASSANDRA = "kpearl@example.com";

    public static final String VALID_ADDRESS_AMY = "Block 312, Amy Street 1";
    public static final String VALID_ADDRESS_BOB = "Block 123, Bobby Street 3";
    public static final String VALID_ADDRESS_DAVID = "10th Fly street";
    public static final String VALID_ADDRESS_LINCOLN = "11th Boxer street";
    public static final String VALID_ADDRESS_KASSANDRA = "13th Jewel street";

    public static final String VALID_DATE_OF_BIRTH_AMY = "1.1.1991";
    public static final String VALID_DATE_OF_BIRTH_BOB = "2.2.1992";
    public static final String VALID_DATE_OF_BIRTH_DAVID = "5.3.1980";
    public static final String VALID_DATE_OF_BIRTH_LINCOLN = "1.3.1990";
    public static final String VALID_DATE_OF_BIRTH_KASSANDRA = "9.10.2000";

    public static final String VALID_GENDER_AMY = "Female";
    public static final String VALID_GENDER_BOB = "Male";
    public static final String VALID_GENDER_DAVID = "Male";
    public static final String VALID_GENDER_LINCOLN = "Male";
    public static final String VALID_GENDER_KASSANDRA = "Female";

    public static final String VALID_POLICY_HEALTH = "Health Insurance";
    public static final String VALID_POLICY_LIFE = "Life Insurance";

    public static final String VALID_TAG_DIABETIC = "diabetic";
    public static final String VALID_TAG_SMOKER = "smoker";

    public static final String NAME_DESC_AMY = " " + PREFIX_NAME + VALID_NAME_AMY;
    public static final String NAME_DESC_BOB = " " + PREFIX_NAME + VALID_NAME_BOB;

    public static final String NRIC_DESC_AMY = " " + PREFIX_NRIC + VALID_NRIC_AMY;
    public static final String NRIC_DESC_BOB = " " + PREFIX_NRIC + VALID_NRIC_BOB;

    public static final String PHONE_DESC_AMY = " " + PREFIX_PHONE + VALID_PHONE_AMY;
    public static final String PHONE_DESC_BOB = " " + PREFIX_PHONE + VALID_PHONE_BOB;

    public static final String EMAIL_DESC_AMY = " " + PREFIX_EMAIL + VALID_EMAIL_AMY;
    public static final String EMAIL_DESC_BOB = " " + PREFIX_EMAIL + VALID_EMAIL_BOB;

    public static final String ADDRESS_DESC_AMY = " " + PREFIX_ADDRESS + VALID_ADDRESS_AMY;
    public static final String ADDRESS_DESC_BOB = " " + PREFIX_ADDRESS + VALID_ADDRESS_BOB;

    public static final String DATE_OF_BIRTH_DESC_AMY = " " + PREFIX_DATE_OF_BIRTH + VALID_DATE_OF_BIRTH_AMY;
    public static final String DATE_OF_BIRTH_DESC_BOB = " " + PREFIX_DATE_OF_BIRTH + VALID_DATE_OF_BIRTH_BOB;

    public static final String GENDER_DESC_AMY = " " + PREFIX_GENDER + VALID_GENDER_AMY;
    public static final String GENDER_DESC_BOB = " " + PREFIX_GENDER + VALID_GENDER_BOB;

    public static final String POLICY_DESC_HEALTH = " " + PREFIX_POLICY + VALID_POLICY_HEALTH;
    public static final String POLICY_DESC_LIFE = " " + PREFIX_POLICY + VALID_POLICY_LIFE;

    public static final String TAG_DESC_DIABETIC = " " + PREFIX_TAG + VALID_TAG_DIABETIC;
    public static final String TAG_DESC_SMOKER = " " + PREFIX_TAG + VALID_TAG_SMOKER;

    public static final String INVALID_NAME_DESC = " " + PREFIX_NAME + "James&"; // '&' not allowed in names
    public static final String INVALID_NRIC_DESC = " " + PREFIX_NRIC + "A000001J"; // A not allowed at the start of Nric
    public static final String INVALID_PHONE_DESC = " " + PREFIX_PHONE + "911a"; // 'a' not allowed in phones
    public static final String INVALID_EMAIL_DESC = " " + PREFIX_EMAIL + "bob!yahoo"; // missing '@' symbol
    public static final String INVALID_ADDRESS_DESC = " " + PREFIX_ADDRESS; // empty string not allowed for addresses
    public static final String INVALID_DATE_OF_BIRTH_DESC = " " + PREFIX_DATE_OF_BIRTH + "12/12/2019";
    public static final String INVALID_GENDER_DESC = " " + PREFIX_GENDER + "not sure";
    // slashes not allowed for date of birth
    public static final String INVALID_POLICY_DESC = " " + PREFIX_POLICY + "health*"; // '*' not allowed in policy names
    public static final String INVALID_TAG_DESC = " " + PREFIX_TAG + "hubby*"; // '*' not allowed in tags

    public static final String PREAMBLE_WHITESPACE = "\t  \r  \n";
    public static final String PREAMBLE_NON_EMPTY = "NonEmptyPreamble";

    public static final EditCommand.EditPersonDescriptor DESC_AMY;
    public static final EditCommand.EditPersonDescriptor DESC_BOB;

    // Policies
    public static final String VALID_NAME_HEALTH_INSURANCE = "Health Insurance";
    public static final String VALID_NAME_LIFE_INSURANCE = "Life Insurance";
    public static final String VALID_NAME_FIRE_INSURANCE = "Fire Insurance";
    public static final String VALID_NAME_CAR_INSURANCE = "Car Insurance";

    public static final String VALID_DESCRIPTION_HEALTH_INSURANCE = "Insurance for healthcare";
    public static final String VALID_DESCRIPTION_LIFE_INSURANCE = "Insurance for life";
    public static final String VALID_DESCRIPTION_FIRE_INSURANCE = "Insurance for fire";
    public static final String VALID_DESCRIPTION_CAR_INSURANCE = "Insurance for car";

    public static final String VALID_COVERAGE_HEALTH_INSURANCE = "days/10 months/11 years/12";
    public static final String VALID_COVERAGE_LIFE_INSURANCE = "years/50";
    public static final String VALID_COVERAGE_FIRE_INSURANCE = "days/30 months/12";
    public static final String VALID_COVERAGE_CAR_INSURANCE = "months/6 years/5";

    public static final String VALID_START_AGE_HEALTH_INSURANCE = "30";
    public static final String VALID_START_AGE_LIFE_INSURANCE = "21";
    public static final String VALID_START_AGE_FIRE_INSURANCE = "0";
    public static final String VALID_START_AGE_CAR_INSURANCE = "18";

    public static final String VALID_END_AGE_HEALTH_INSURANCE = "75";
    public static final String VALID_END_AGE_LIFE_INSURANCE = "80";
    public static final String VALID_END_AGE_FIRE_INSURANCE = "5";
    public static final String VALID_END_AGE_CAR_INSURANCE = "100";

    public static final String VALID_PRICE_HEALTH_INSURANCE = "$50000";
    public static final String VALID_PRICE_LIFE_INSURANCE = "$1000000";
    public static final String VALID_PRICE_FIRE_INSURANCE = "$7500";
    public static final String VALID_PRICE_CAR_INSURANCE = "$5000";

    public static final String VALID_CRITERIA_HEALTH_INSURANCE = "diabetic";
    public static final String VALID_CRITERIA_LIFE_INSURANCE = "high blood pressure";
    public static final String VALID_CRITERIA_FIRE_INSURANCE = "public housing";
    public static final String VALID_CRITERIA_CAR_INSURANCE = "owns car";

    public static final String VALID_TAG_HEALTH_INSURANCE = "health insurance";
    public static final String VALID_TAG_LIFE_INSURANCE = "term insurance";
    public static final String VALID_TAG_FIRE_INSURANCE = "home insurance";
    public static final String VALID_TAG_CAR_INSURANCE = "car insurance";

    // binItems
    public static final String VALID_DATE_DELETED_DAVID = "22 Oct 2019 at 09:57 PM";
    public static final String VALID_DATE_DELETED_LINCOLN = "23 Oct 2019 at 09:57 PM";
    public static final String VALID_DATE_DELETED_KASSANDRA = "24 Oct 2019 at 09:57 PM";
    public static final String VALID_DATE_DELETED_CAR_INSURANCE = "25 Oct 2019 at 09:57 PM";

    public static final String VALID_EXPIRY_DATE_DAVID = "21 Nov 2019 at 09:57 PM";
    public static final String VALID_EXPIRY_DATE_LINCOLN = "22 Nov 2019 at 09:57 PM";
    public static final String VALID_EXPIRY_DATE_KASSANDRA = "23 Nov 2019 at 09:57 PM";
    public static final String VALID_EXPIRY_DATE_CAR_INSURANCE = "24 Nov 2019 at 09:57 PM";

    public static final String POLICY_NAME_DESC_HEALTH = " " + PREFIX_NAME + VALID_NAME_HEALTH_INSURANCE;
    public static final String POLICY_NAME_DESC_FIRE = " " + PREFIX_NAME + VALID_NAME_FIRE_INSURANCE;
    public static final String DESCRIPTION_DESC_HEALTH = " " + PREFIX_DESCRIPTION + VALID_DESCRIPTION_HEALTH_INSURANCE;
    public static final String DESCRIPTION_DESC_FIRE = " " + PREFIX_DESCRIPTION + VALID_DESCRIPTION_FIRE_INSURANCE;
    public static final String COVERAGE_DESC_HEALTH = " " + PREFIX_COVERAGE + VALID_COVERAGE_HEALTH_INSURANCE;
    public static final String COVERAGE_DESC_FIRE = " " + PREFIX_COVERAGE + VALID_COVERAGE_FIRE_INSURANCE;
    public static final String PRICE_DESC_HEALTH = " " + PREFIX_PRICE + VALID_PRICE_HEALTH_INSURANCE;
    public static final String PRICE_DESC_FIRE = " " + PREFIX_PRICE + VALID_PRICE_FIRE_INSURANCE;
    public static final String START_AGE_DESC_HEALTH = " " + PREFIX_START_AGE + VALID_START_AGE_HEALTH_INSURANCE;
    public static final String START_AGE_DESC_FIRE = " " + PREFIX_START_AGE + VALID_START_AGE_FIRE_INSURANCE;
    public static final String END_AGE_DESC_HEALTH = " " + PREFIX_END_AGE + VALID_END_AGE_HEALTH_INSURANCE;
    public static final String END_AGE_DESC_FIRE = " " + PREFIX_END_AGE + VALID_END_AGE_FIRE_INSURANCE;
    public static final String CRITERIA_DESC_HEALTH = " " + PREFIX_CRITERIA + VALID_CRITERIA_HEALTH_INSURANCE;

    public static final String INVALID_POLICY_NAME_DESC = " " + PREFIX_NAME + "Insurance&"; // '&' not allowed in names
    public static final String INVALID_COVERAGE_DESC = " " + PREFIX_COVERAGE + "10 months"; // should be months/10
    public static final String INVALID_PRICE_DESC = " " + PREFIX_PRICE + "40000"; // missing '$' symbol
    public static final String INVALID_START_AGE = " " + PREFIX_START_AGE + "twenty"; // only numbers are allowed
    public static final String INVALID_END_AGE = " " + PREFIX_END_AGE + "20-30"; // only numbers are allowed

    static {
        DESC_AMY = new EditPersonDescriptorBuilder().withName(VALID_NAME_AMY).withNric(VALID_NRIC_AMY)
            .withPhone(VALID_PHONE_AMY).withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY)
            .withDateOfBirth(VALID_DATE_OF_BIRTH_AMY).build();
        DESC_BOB = new EditPersonDescriptorBuilder().withName(VALID_NAME_BOB)
            .withPhone(VALID_PHONE_BOB).withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB)
            .withDateOfBirth(VALID_DATE_OF_BIRTH_BOB).build();
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - the returned {@link CommandResult} matches {@code expectedCommandResult} <br>
     * - the {@code actualModel} matches {@code expectedModel}
     */
    public static void assertCommandSuccess(Command command, Model actualModel, CommandResult expectedCommandResult,
                                            Model expectedModel) {
        try {
            CommandResult result = command.execute(actualModel);
            System.out.println(result.getFeedbackToUser());
            System.out.println(expectedCommandResult.getFeedbackToUser());
            assertEquals(expectedCommandResult, result);
            assertEquals(expectedModel, actualModel);
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, Model, CommandResult, Model)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertCommandSuccess(Command command, Model actualModel, String expectedMessage,
                                            Model expectedModel) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, Model, CommandResult, Model)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertListPeopleCommandSuccess(Command command, Model actualModel, String expectedMessage,
                                                      Model expectedModel) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage, false, false, false, true,
            false, false, false, false, false, false);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, Model, CommandResult, Model)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertListPolicyCommandSuccess(Command command, Model actualModel, String expectedMessage,
                                                      Model expectedModel) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage, false, false, true, false,
            false, false, false, false, false, false);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, Model, CommandResult, Model)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertHistoryCommandSuccess(Command command, Model actualModel, String expectedMessage,
                                                   Model expectedModel) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage, false, false,
            false, false, false, false, false, false, true, false);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - a {@code CommandException} is thrown <br>
     * - the CommandException message matches {@code expectedMessage} <br>
     * - the address book, filtered person list and selected person in {@code actualModel} remain unchanged
     */
    public static void assertCommandFailure(Command command, Model actualModel, String expectedMessage) {
        // we are unable to defensively copy the model for comparison later, so we can
        // only do so by copying its components.
        AddressBook expectedAddressBook = new AddressBook(actualModel.getAddressBook());
        List<Person> expectedFilteredList = new ArrayList<>(actualModel.getFilteredPersonList());

        assertThrows(CommandException.class, expectedMessage, () -> command.execute(actualModel));
        assertEquals(expectedAddressBook, actualModel.getAddressBook());
        assertEquals(expectedFilteredList, actualModel.getFilteredPersonList());
    }

    /**
     * Updates {@code model}'s filtered list to show only the person at the given {@code targetIndex} in the
     * {@code model}'s address book.
     */
    public static void showPersonAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredPersonList().size());

        Person person = model.getFilteredPersonList().get(targetIndex.getZeroBased());
        final String[] splitName = person.getName().fullName.split("\\s+");
        model.updateFilteredPersonList(new NameContainsKeywordsPredicate(Arrays.asList(splitName[0])));

        assertEquals(1, model.getFilteredPersonList().size());
    }

    /**
     * Updates {@code model}'s filtered list to show only the policy at the given {@code targetIndex} in the
     * {@code model}'s address book.
     *
     * @param model
     * @param targetIndex
     */
    public static void showPolicyAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredPolicyList().size());

        Policy policy = model.getFilteredPolicyList().get(targetIndex.getZeroBased());
        final String[] splitName = policy.getName().policyName.split("\\s+");
        model.updateFilteredPolicyList(new PolicyNameContainsKeywordsPredicate(Arrays.asList(splitName[0])));

        assertEquals(1, model.getFilteredPolicyList().size());
    }
}

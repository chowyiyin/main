package seedu.address.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.person.Person;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class PersonCard extends UiPart<Region> {

    private static final String FXML = "PersonListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Person person;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label nric;
    @FXML
    private Label phone;
    @FXML
    private Label address;
    @FXML
    private Label dateOfBirth;
    @FXML
    private Label gender;
    @FXML
    private Label email;
    @FXML
    private FlowPane policies;
    @FXML
    private FlowPane tags;

    public PersonCard(Person person, int displayedIndex) {
        super(FXML);
        this.person = person;
        id.setText(displayedIndex + ". ");
        name.setText(person.getName().fullName);
        nric.setText(person.getNric().nric);
        phone.setText(person.getPhone().value);
        address.setText(person.getAddress().value);
        dateOfBirth.setText(person.getDateOfBirth().value);
        gender.setText(person.getGender().gender);
        email.setText(person.getEmail().value);
        person.getPolicies().stream()
                .sorted(Comparator.comparing(policy -> policy.getName().policyName))
                .forEach(policy -> policies.getChildren().add(new Label(policy.getName().policyName)));
        person.getTags().stream()
                .sorted(Comparator.comparing(tag -> tag.tagName))
                .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
    }

    /**
     * Custom fxml passed in. Used by BinPersonCard.
     */
    public PersonCard(Person person, int displayedIndex, String fxml) {
        super(fxml);
        this.person = person;
        id.setText(displayedIndex + ". ");
        name.setText(person.getName().fullName);
        nric.setText(person.getNric().nric);
        phone.setText(person.getPhone().value);
        address.setText(person.getAddress().value);
        dateOfBirth.setText(person.getDateOfBirth().value);
        gender.setText(person.getGender().gender);
        email.setText(person.getEmail().value);
        person.getPolicies().stream()
            .sorted(Comparator.comparing(policy -> policy.getName().policyName))
            .forEach(policy -> policies.getChildren().add(new Label(policy.getName().policyName)));
        person.getTags().stream()
            .sorted(Comparator.comparing(tag -> tag.tagName))
            .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PersonCard)) {
            return false;
        }

        // state check
        PersonCard card = (PersonCard) other;
        return id.getText().equals(card.id.getText())
                && person.equals(card.person);
    }
}

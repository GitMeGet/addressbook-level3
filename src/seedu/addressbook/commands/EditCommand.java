package seedu.addressbook.commands;

import java.util.Iterator;

import seedu.addressbook.Main;
import seedu.addressbook.common.Messages;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.ui.MainWindow;

/**
 * Edits a person's details 
 */
public class EditCommand extends Command {

    public static final String COMMAND_WORD = "edit";
    public static final String NEXT_COMMAND_WORD = "actualEdit";
    
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits the person identified by the index number used in the last person listing.\n"
            + "Parameters: INDEX\n"
            + "Example: " + COMMAND_WORD + " 1";
    
    public static final String MESSAGE_EDIT_PERSON_PROMPT = "Edit the following person: %1$s\n\n Press enter to confirm your edit";
    public static final String MESSAGE_EDIT_PERSON_SUCCESS = "Person successfully edited: %1$s";
    
    public static boolean isEditingPerson;
    public static ReadOnlyPerson toRemove;
    
    private MainWindow window;
    private ReadOnlyPerson target;
    
    public EditCommand(int targetVisibleIndex) {
        super(targetVisibleIndex);
    }
    
    @Override
    public CommandResult execute() {
        
        window = Main.gui.getMainWindow();
        try {
            target = getTargetPerson();
            String personInfo = getPersonInfo();
            window.displayCommandInput(personInfo); 
            isEditingPerson = true;
            toRemove = target;
            return new CommandResult(String.format(MESSAGE_EDIT_PERSON_PROMPT, target));

        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }
        
    }

    private String getPersonInfo() {
        String personInfo = target.getName() + " p/" + target.getPhone() + " e/" + target.getEmail() 
            + " a/" + target.getAddress();
        Iterator<Tag> iterator = target.getTags().iterator();
        while (iterator.hasNext()){
            personInfo += " t/" + iterator.next().toString();
        }
        return personInfo;
    }
    
}

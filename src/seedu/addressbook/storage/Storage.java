package seedu.addressbook.storage;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.storage.StorageFile.StorageOperationException;

public interface Storage {

    abstract public String getPath();
    abstract public AddressBook load() throws StorageOperationException;
    abstract public void save(AddressBook addressBook) throws StorageOperationException;
}

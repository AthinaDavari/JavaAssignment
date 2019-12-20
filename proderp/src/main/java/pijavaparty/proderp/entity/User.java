package pijavaparty.proderp.entity;

import java.util.Objects;

/**
 * User.java - a class with the necessary getters and setters for a User data
 * type object.
 *
 * @author athinaDavari
 */
public class User {

    private String fullName;
    private String username;
    private String password;
    private Role role;

    /**
     * A Constructor with arguments.
     *
     * @param fullName A variable of type String.
     * @param username A variable of type String.
     * @param password A variable of type String.
     * @param role A variable of type Role.
     */
    public User(String fullName, String username, String password, Role role) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    /**
     * A Constructor with arguments.
     *
     * @param fullName A variable of type String.
     * @param username A variable of type String.
     * @param password A variable of type String.
     * @param role A variable of type String.
     */
    public User(String fullName, String username, String password, String role) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.role = Role.valueOf(role);
    }

    /**
     * A no-argument Constructor.
     */
    public User() {
    }

    /**
     * A Constructor with arguments.
     *
     * @param fullName A variable of type String.
     * @param password A variable of type String.
     * @param role A variable of type Role.
     */
    public User(String fullName, String username, Role role) {
        this.fullName = fullName;
        this.username = username;
        this.role = role;
    }

    /**
     * A Constructor with arguments.
     *
     * @param fullName A variable of type String.
     * @param username A variable of type String.
     * @param role A variable of type String.
     */
    public User(String fullName, String username, String role) {
        this.fullName = fullName;
        this.username = username;
        this.role = Role.valueOf(role);
    }

    /**
     * Enable to status to be a set of predefined constants.
     */
    enum Role {
        admin, simpleuser
    }

    /**
     * Set the value of fullName.
     *
     * @param fullName A variable of type String.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Set the value of username.
     *
     * @param username A variable of type String.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Set the value of password.
     *
     * @param password A variable of type String.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Set the value of role.
     *
     * @param role A variable of type Role.
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Retrieve the value of fullName.
     *
     * @return A String data type.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Retrieve the value of username.
     *
     * @return A Sting data type.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Retrieve the value of password.
     *
     * @return A String data type.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Retrieve the value of role.
     *
     * @return A String data type.
     */
    public String getRole() {
        return role.name();
    }

    /**
     * Return the hash code value for this set.
     *
     * @return An int data type.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.fullName);
        hash = 71 * hash + Objects.hashCode(this.username);
        hash = 71 * hash + Objects.hashCode(this.password);
        hash = 71 * hash + Objects.hashCode(this.role);
        return hash;
    }

    /**
     * Compare the specified object with this set for equality.
     *
     * @param obj A variable of type Object.
     * @return A boolean data type.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.fullName, other.fullName)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (this.role != other.role) {
            return false;
        }
        return true;
    }

    /**
     * Return a string representation of this collection.
     *
     * @return A String data type.
     */
    @Override
    public String toString() {
        return "User{" + "fullName=" + fullName + ", username=" + username + ", password=" + password + ", role=" + role + '}';
    }

}

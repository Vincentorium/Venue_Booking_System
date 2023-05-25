<%@ page language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.itp4511.domain.User" %>
<%@ page import="com.itp4511.domain.Role" %>

<%
    // Initialize user and role data
    List<User> userList = new ArrayList<>();
    userList.add(new User("John", "Doe", "john@example.com", Role.ADMIN));
    userList.add(new User("Jane", "Doe", "jane@example.com", Role.USER));
    userList.add(new User("Bob", "Smith", "bob@example.com", Role.USER));

    //Map<String, Role> roleMap = new HashMap<>();
   // roleMap.put("admin", Role.ADMIN);
  //  roleMap.put("user", Role.USER);

// Handle form submissions
    String action = request.getParameter("action");
    if (action != null) {
        if (action.equals("create")) {
            String firstName = request.getParameter("first_name");
            String lastName = request.getParameter("last_name");
            String email = request.getParameter("email");
            String roleStr = request.getParameter("role");
            Role role = roleMap.get(roleStr);
            User user = new User(firstName, lastName, email, role);
            userList.add(user);
        } else if (action.equals("delete")) {
            int userId = Integer.parseInt(request.getParameter("user_id"));
            userList.remove(userId);
        } else if (action.equals("edit")) {
            int userId = Integer.parseInt(request.getParameter("user_id"));
            User user = userList.get(userId);
            user.setFirstName(request.getParameter("first_name"));
            user.setLastName(request.getParameter("last_name"));
            user.setEmail(request.getParameter("email"));
            user.setRole(roleMap.get(request.getParameter("role")));
        }
    }

%>

<!DOCTYPE html>
<html>
<head>
    <title>Account Management</title>
</head>
<body>
<h1>Account Management</h1>
<h2>Existing Users</h2>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Role</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <% for (int i = 0; i < userList.size(); i++) { %>
    <tr>
        <td><%= i %>
        </td>
        <td><%= userList.get(i).getFirstName() %>
        </td>
        <td><%= userList.get(i).getLastName() %>
        </td>
        <td><%= userList.get(i).getEmail() %>
        </td>
        <td><%= userList.get(i).getRole() %>
        </td>
        <td>
            <form method="post">
                <input type="hidden" name="user_id" value="<%= i %>">
                <input type="hidden" name="action" value="delete">
                <button type="submit">Delete</button>
            </form>
            <form method="get" action="edit_user.jsp">
                <input type="hidden" name="user_id" value="<%= i %>">
                <button type="submit">Edit</button>
            </form>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>

<h2>Create User</h2>
<form method="post">
    <label>First Name:</label>
    <input type="text" name="first_name"><br>
    <label>Last Name：</label>
    <input type="text" name="last_name"><br>
    <label>Email：</label>
    <input type="email" name="email"><br>
    <label>Role：</label>
    <select name="role">
        <option value="admin">ADMIN</option>
        <option value="user">USER</option>
    </select><br>
    <input type="hidden" name="action" value="create">
    <button type="submit">Create User</button>
</form>
</body>

</html>
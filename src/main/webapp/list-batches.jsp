<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
           prefix="c" %>

<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>Batches · Zumba Management</title>

    <link rel="stylesheet"
          href="css/style.css">

</head>

<body>

<div class="page-shell">

    <header class="topbar">

        <a class="brand"
           href="index.html">

            <span class="brand-mark">

                <svg viewBox="0 0 24 24"
                     fill="none"
                     stroke="currentColor"
                     stroke-width="2">

                    <path d="M8 20V9l8-5v16M4 20h16M12 8h.01"/>

                </svg>

            </span>

            <span>Zumba Management</span>

        </a>


        <nav class="top-nav">

            <a href="batches?action=list">
                Batches
            </a>

            <a href="participants?action=list">
                Participants
            </a>

        </nav>

    </header>


    <main>

        <div class="page-header">

            <div>

                <h2>
                    Batches
                </h2>

                <p>
                    Manage your Zumba class schedule and capacity.
                </p>

            </div>


            <a class="btn btn-primary"
               href="add-batch.html">

                + New batch

            </a>

        </div>


        <div class="surface table-wrap">

            <table>

                <thead>

                <tr>

                    <th>ID</th>

                    <th>Batch</th>

                    <th>Time</th>

                    <th>Capacity</th>

                    <th>Status</th>

                    <th>Actions</th>

                </tr>

                </thead>


                <tbody>

                <c:forEach var="b"
                           items="${batchList}">

                    <tr>

                        <td>
                            ${b.batchId}
                        </td>

                        <td>
                            <strong>
                                ${b.batchName}
                            </strong>
                        </td>

                        <td>
                            ${b.timeSlot}
                        </td>

                        <td>
                            ${b.maxCapacity}
                        </td>

                        <td>

                            <span class="badge">
                                Active
                            </span>

                        </td>

                        <td class="actions">

                            <a href="batches?action=edit&id=${b.batchId}"
                               class="btn btn-warning">

                                Edit

                            </a>

                            <a href="batches?action=delete&id=${b.batchId}"
                               class="btn btn-danger"
                               onclick="return confirm('Are you sure? Removing this batch unlinks its participants.');">

                                Delete

                            </a>

                        </td>

                    </tr>

                </c:forEach>

                </tbody>

            </table>


            <c:if test="${empty batchList}">

                <div class="empty-state">

                    <div class="empty-icon">
                        —
                    </div>

                    <h3>
                        No batches yet
                    </h3>

                    <p class="muted">
                        Create your first class to get started.
                    </p>

                    <a class="btn btn-primary"
                       href="add-batch.html">

                        Create batch

                    </a>

                </div>

            </c:if>

        </div>

    </main>


    <footer class="footer">
        Zumba Class Management System
    </footer>

</div>

</body>

</html>
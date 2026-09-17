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

    <title>Participants · Zumba Management</title>

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
                    Participants
                </h2>

                <p>
                    View enrolled members and their current batch assignments.
                </p>

            </div>


            <a class="btn btn-primary"
               href="participants?action=new">

                + Enroll participant

            </a>

        </div>


        <div class="surface table-wrap">

            <table>

                <thead>

                <tr>

                    <th>ID</th>

                    <th>Participant</th>

                    <th>Email</th>

                    <th>Phone</th>

                    <th>Batch</th>

                    <th>Actions</th>

                </tr>

                </thead>


                <tbody>

                <c:forEach var="p"
                           items="${participantList}">

                    <tr>

                        <td>
                            ${p.participantId}
                        </td>


                        <td>

                            <strong>
                                ${p.fullName}
                            </strong>

                        </td>


                        <td>
                            ${p.email}
                        </td>


                        <td>
                            ${p.phone}
                        </td>


                        <td>

                            <c:choose>

                                <c:when test="${not empty p.batchName}">

                                    <span class="badge">
                                        ${p.batchName}
                                    </span>

                                </c:when>


                                <c:otherwise>

                                    <span class="muted">
                                        Unassigned
                                    </span>

                                </c:otherwise>

                            </c:choose>

                        </td>


                        <td class="actions">

                            <a href="participants?action=edit&id=${p.participantId}"
                               class="btn btn-warning">

                                Edit

                            </a>


                            <a href="participants?action=delete&id=${p.participantId}"
                               class="btn btn-danger"
                               onclick="return confirm('Are you sure you want to remove this participant?');">

                                Delete

                            </a>

                        </td>

                    </tr>

                </c:forEach>

                </tbody>

            </table>


            <c:if test="${empty participantList}">

                <div class="empty-state">

                    <div class="empty-icon">
                        —
                    </div>

                    <h3>
                        No participants yet
                    </h3>

                    <p class="muted">
                        Enroll your first participant to get started.
                    </p>

                    <a class="btn btn-primary"
                       href="participants?action=new">

                        Enroll participant

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
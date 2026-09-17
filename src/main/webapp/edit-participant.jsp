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

    <title>Edit Participant · Zumba Management</title>

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
                    Edit participant
                </h2>

                <p>
                    Update contact details or reassign the participant.
                </p>

            </div>

            <a class="btn btn-secondary"
               href="participants?action=list">

                Back to participants

            </a>

        </div>


        <form class="form-card"
              action="participants"
              method="POST">

            <div class="form-card-header">

                <h3>
                    Participant details
                </h3>

                <p>
                    Changes are saved directly to the MySQL database.
                </p>

            </div>


            <input type="hidden"
                   name="action"
                   value="update">

            <input type="hidden"
                   name="participantId"
                   value="${participant.participantId}">


            <div class="form-grid">

                <div class="form-group full">

                    <label for="fullName">
                        Full name
                    </label>

                    <input id="fullName"
                           type="text"
                           name="fullName"
                           value="${participant.fullName}"
                           required>

                </div>


                <div class="form-group">

                    <label for="email">
                        Email address
                    </label>

                    <input id="email"
                           type="email"
                           name="email"
                           value="${participant.email}"
                           required>

                </div>


                <div class="form-group">

                    <label for="phone">
                        Phone number
                    </label>

                    <input id="phone"
                           type="text"
                           name="phone"
                           value="${participant.phone}"
                           required>

                </div>


                <div class="form-group full">

                    <label for="batchId">
                        Assigned batch
                    </label>

                    <select id="batchId"
                            name="batchId">

                        <option value="">
                            No batch
                        </option>

                        <c:forEach var="b"
                                   items="${batches}">

                            <option value="${b.batchId}"
                                <c:if test="${participant.batchId == b.batchId}">
                                    selected
                                </c:if>>

                                ${b.batchName} · ${b.timeSlot}

                            </option>

                        </c:forEach>

                    </select>

                </div>

            </div>


            <div class="form-actions">

                <a class="btn btn-secondary"
                   href="participants?action=list">

                    Cancel

                </a>

                <button class="btn btn-primary"
                        type="submit">

                    Save changes

                </button>

            </div>

        </form>

    </main>

</div>

</body>

</html>
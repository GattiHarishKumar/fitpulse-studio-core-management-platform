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

    <title>Enroll Participant · Zumba Management</title>

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
                    Enroll participant
                </h2>

                <p>
                    Add a member and optionally assign them to a batch.
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
                    Use a unique email address for each participant.
                </p>

            </div>


            <input type="hidden"
                   name="action"
                   value="insert">


            <div class="form-grid">

                <div class="form-group full">

                    <label for="fullName">
                        Full name
                    </label>

                    <input id="fullName"
                           type="text"
                           name="fullName"
                           placeholder="e.g. Sarah Connor"
                           required>

                </div>


                <div class="form-group">

                    <label for="email">
                        Email address
                    </label>

                    <input id="email"
                           type="email"
                           name="email"
                           placeholder="name@example.com"
                           required>

                </div>


                <div class="form-group">

                    <label for="phone">
                        Phone number
                    </label>

                    <input id="phone"
                           type="text"
                           name="phone"
                           placeholder="9876543210"
                           required>

                </div>


                <div class="form-group full">

                    <label for="batchId">
                        Assign batch
                    </label>

                    <select id="batchId"
                            name="batchId">

                        <option value="">
                            Assign later
                        </option>

                        <c:forEach var="b"
                                   items="${batches}">

                            <option value="${b.batchId}">
                                ${b.batchName} · ${b.timeSlot}
                            </option>

                        </c:forEach>

                    </select>

                </div>

            </div>


            <div class="form-actions">

                <a class="btn btn-secondary"
                   href="index.html">

                    Cancel

                </a>

                <button class="btn btn-primary"
                        type="submit">

                    Enroll participant

                </button>

            </div>

        </form>

    </main>

</div>

</body>

</html>
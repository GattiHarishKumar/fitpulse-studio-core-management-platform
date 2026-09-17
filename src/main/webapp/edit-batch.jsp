<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>Edit Batch · Zumba Management</title>

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
                    Edit batch
                </h2>

                <p>
                    Update the schedule or capacity for this class.
                </p>

            </div>

            <a class="btn btn-secondary"
               href="batches?action=list">

                Back to batches

            </a>

        </div>


        <form class="form-card"
              action="batches"
              method="POST">

            <div class="form-card-header">

                <h3>
                    Batch details
                </h3>

                <p>
                    Changes are saved directly to the MySQL database.
                </p>

            </div>


            <input type="hidden"
                   name="action"
                   value="update">

            <input type="hidden"
                   name="batchId"
                   value="${batch.batchId}">


            <div class="form-grid">

                <div class="form-group full">

                    <label for="batchName">
                        Batch name
                    </label>

                    <input id="batchName"
                           type="text"
                           name="batchName"
                           value="${batch.batchName}"
                           required>

                </div>


                <div class="form-group">

                    <label for="timeSlot">
                        Time slot
                    </label>

                    <input id="timeSlot"
                           type="text"
                           name="timeSlot"
                           value="${batch.timeSlot}"
                           required>

                </div>


                <div class="form-group">

                    <label for="maxCapacity">
                        Maximum capacity
                    </label>

                    <input id="maxCapacity"
                           type="number"
                           name="maxCapacity"
                           min="1"
                           max="100"
                           value="${batch.maxCapacity}"
                           required>

                </div>

            </div>


            <div class="form-actions">

                <a class="btn btn-secondary"
                   href="batches?action=list">

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
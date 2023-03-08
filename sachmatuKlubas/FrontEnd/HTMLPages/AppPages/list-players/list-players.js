import { getPlayers } from "/Commons/requests.js";


const rendePlayerTableRows = async (players) => {
    const playerTable = document.getElementById("playerTable");
    const playerTableBody = playerTable.querySelector("tbody");
    console.log(players);
    players.forEach((p) => {
      const playerRow = document.createElement("tr");
  
      const nameCell = document.createElement("td");
      nameCell.innerText = p.firstName;
      playerRow.appendChild(nameCell);
  
      const surnameCell = document.createElement("td");
      surnameCell.innerText = p.lastName;
      playerRow.appendChild(surnameCell);
  
      const mailCell = document.createElement("td");
      mailCell.innerText = p.email;
      playerRow.appendChild(mailCell);

      const genderCell = document.createElement("td");
      genderCell.innerText = p.gender;
      playerRow.appendChild(genderCell);

      const ageCell = document.createElement("td");
      ageCell.innerText = p.age;
      playerRow.appendChild(ageCell);

      const experienceCell = document.createElement("td");
      experienceCell.innerText = p.experience;
      playerRow.appendChild(experienceCell);
  
      const actionCell = document.createElement("td");
      const deleteButton = document.createElement("button");
      deleteButton.innerText = "DELETE";
      deleteButton.className = "btn btn-danger";
      // deleteButton.addEventListener("click", async () => {
      //   await deleteExamById(e.id);
      //   window.location.reload();
      // });
      actionCell.appendChild(deleteButton);
      playerRow.appendChild(actionCell);
  
      playerTableBody.appendChild(playerRow);
    });
  };
  
  const handleAddNewPlayerButton = () => {
    document.getElementById("addPlayer").addEventListener("click", () => {
      window.location.replace("../add-player/add-player.html");
    });
  };
  
  (async () => {
    handleAddNewPlayerButton();
    const players = await getPlayers();
    rendePlayerTableRows(players);
  })();
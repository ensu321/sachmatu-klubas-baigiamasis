import { getPlayers, deletePlayerById } from "/Commons/requests.js";


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
      actionCell.className = "administrationButtonsCell";
      const editButton = document.createElement("button");
      editButton.innerText = "Redaguoti";
      editButton.className = "btn btn-warning";
      editButton.style = "margin-right: 10px";
      editButton.addEventListener("click", async () => {
        window.location.replace(`../edit-player-data/edit-player.html?id=${p.id}`);
      });
      actionCell.appendChild(editButton);
      const deleteButton = document.createElement("button");
      deleteButton.innerText = "Ištrinti";
      deleteButton.className = "btn btn-danger";
      deleteButton.addEventListener("click", async () => {
        await deletePlayerById(p.id);
        window.location.reload();
      });
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
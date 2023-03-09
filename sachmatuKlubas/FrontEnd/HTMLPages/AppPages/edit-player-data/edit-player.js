import { getPlayerByID, patchPlayer } from "../../../Commons/requests.js";

const editPlayerForm = document
  .getElementById("editPlayerForm")
  .querySelector("form");

let oldPlayerData;

const loadPlayerData = async () => {
  const urlParams = new URLSearchParams(window.location.search);
  const playerId = urlParams.get("id");
  oldPlayerData = await getPlayerByID(playerId);
  editPlayerForm.playerName.value = oldPlayerData.firstName;
  editPlayerForm.playerSurname.value = oldPlayerData.lastName;
  editPlayerForm.playerEmail.value = oldPlayerData.email;
  editPlayerForm.playerPersonalCode.value = oldPlayerData.personalCode;
  editPlayerForm.playerStartDate.value = oldPlayerData.startDate;
};

const handleFormSubmit = async () => {
  console.log("hello");
  editPlayerForm.addEventListener("submit", async (e) => {
    e.preventDefault();
   
    const player = {
      firstName: 
        oldPlayerData.firstName !== editPlayerForm.playerName.value
          ? editPlayerForm.playerName.value
          : undefined,
      lastName:
        oldPlayerData.playerSurname !== editPlayerForm.playerSurname.value
          ? editPlayerForm.playerSurname.value
          : undefined,
      email:
          oldPlayerData.email !== editPlayerForm.playerEmail.value
          ? editPlayerForm.playerEmail.value
          : undefined,
     personalCode:
          oldPlayerData.personalCode !== editPlayerForm.playerPersonalCode.value
          ? editPlayerForm.playerPersonalCode.value
          : undefined,    
      startDate: 
      oldPlayerData.startDate !== editPlayerForm.playerStartDate.value
      ? editPlayerForm.playerStartDate.value
      : undefined,   
    };

 

    await patchPlayer(player, oldPlayerData.id);
    window.location.replace("../list-players/list-players.html");
  });
};

const handleCancelButton = () => {
  document.getElementById("cancelButton").addEventListener("click", () => {
    window.location.replace("../list-players/list-players.html");
  });
};

(async () => {
  await loadPlayerData();
  handleCancelButton();
  await handleFormSubmit();
})();

import { getPlayerByID, patchPlayer } from "../../../Commons/requests.js";

//html form
const editPlayerForm = document
  .getElementById("editPlayerForm")
  .querySelector("form");

//player data which is being filled on player load
let oldPlayerData;

//function load the player data to form fields
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

//function handles form submit and patches data to database
const handleFormSubmit = async () => {
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

//function handles cancel action
const handleCancelButton = () => {
  document.getElementById("cancelButton").addEventListener("click", () => {
    window.location.replace("../list-players/list-players.html");
  });
};

// self-invoking async function in JavaScript. It is immediately invoked when the code is executed, and it runs asynchronously due to the async keyword.
(async () => {
  await loadPlayerData();
  handleCancelButton();
  await handleFormSubmit();
})();

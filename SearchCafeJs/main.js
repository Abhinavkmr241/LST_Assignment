var cafeDirectory = [];
async function init() {
  try {
    let response = await fetch(
      "https://raw.githubusercontent.com/debojyoti/places-fake-rest-api/master/cafes.json"
    );
    let responseJson = await response.json();
    const cafes = responseJson.cafes;
    response = await fetch(
      "https://raw.githubusercontent.com/debojyoti/places-fake-rest-api/master/places.json"
    );
    responseJson = await response.json();
    const places = responseJson.places;
    for (const cafe of cafes) {
      const place = places.find((place) => cafe.location_id == place.id);
      cafeDirectory.push({ ...cafe, ...place });
    }
    renderTable(cafeDirectory);
  } catch (error) {
    console.log(error);
    alert(error);
  }
}

function renderTable(directory) {
  let tableData = "";
  if (directory.length) {
    directory.forEach((entry, index) => {
      tableData +=
        "<tr>" +
        "<td class='column1'>" +
        (index + 1) +
        "</td>" +
        "<td class='column2'>" +
        entry.name +
        "</td>" +
        "<td class='column3'>" +
        entry.street_no +
        ", " +
        entry.locality +
        "</td>" +
        "<td class='column4'>" +
        entry.postal_code +
        "</td>" +
        "<td class='column5'>" +
        entry.lat +
        "</td>" +
        "<td class='column6'>" +
        entry.long +
        "</td>" +
        "</tr>";
    });
  } else {
    tableData += "<tr><td style='text-center'>No Cafe found</td></tr>";
  }
  document.getElementById("table-data").innerHTML = tableData;
}

function searchCafe(event) {
  const searchValue = event.target.value;
  var filteredArray = cafeDirectory.filter((entry) =>
    entry.name.toLowerCase().includes(searchValue.toLowerCase())
  );
  renderTable(filteredArray);
}

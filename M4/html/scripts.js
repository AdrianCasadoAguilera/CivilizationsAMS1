
function loadXMLDoc(filename) {
    let xhttp;
    if (window.XMLHttpRequest) {
        xhttp = new XMLHttpRequest();
    } else {
        // Para navegadores antiguos
        xhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xhttp.open("GET", filename, false);
    xhttp.send();
    return xhttp.responseXML;
}

function displayResult(xmlFile, xslFile, elementId) {
    let xml = loadXMLDoc(xmlFile);
    let xsl = loadXMLDoc(xslFile);
    if (window.XSLTProcessor) {
        let xsltProcessor = new XSLTProcessor();
        xsltProcessor.importStylesheet(xsl);
        let resultDocument = xsltProcessor.transformToFragment(xml, document);
        document.getElementById(elementId).appendChild(resultDocument);
    }
}

window.onload = function() {
    if (document.getElementById("attack-units-table")) {
        displayResult("../xml/attack_units.xml", "../xml/attack_units.xsl", "attack-units-table");
    }
    if (document.getElementById("buildings-table")) {
        displayResult("../xml/buildings.xml", "../xml/buildings.xsl", "buildings-table");
    }
};

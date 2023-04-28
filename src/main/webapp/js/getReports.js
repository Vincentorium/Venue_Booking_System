
function getReports2(result, reportID) {

  //alert("caller is " + getReports2.caller);


  var content = ""
  var type
  repID = reportID


  $.ajax({
    url: "./php/getReportsSpecific.php",
    dataType: "json",
    type: 'POST',
    async: false,
    data: {
      repid: repID
    },
    success: function (rs) {

      data = rs[0]

      type = data.repType;


      let repDept = data.repDept
      let otherDescription = " ";
      /*              
                    if(type==="Others"){
      
                    otherDescription=
       '                      <tr class="othersSpe">'
      +'                        <td>'
        +'                   <b>Specification: </b>:'
      +'             Others Specification           '    
      +'                        </td>'
      +'                      </tr>'
      
                    }
      
      
      */





      //let repDept=(data.repDept==""?"unassigned":data.repDept);

      let numOfAttach = (data.images.length)
      let havaAttach = ((data.images != 0) && numOfAttach > 0);

      let mailAttachment = ""
      if (havaAttach) {

        for (let i = 0; i < numOfAttach; i++) {
          mailAttachment += '  <a href="./php/uploads/' + data.images[i] + '" download>'
            + '<img class="repContentPic" width="500px" src="./php/uploads/' + data.images[i] + '" alt="No"   style="display: ' + (havaAttach === true ? "inline" : "none") + '"></a>'

        }
      }





      content +=


        '<a href="#" class="float" data-repID=' + data.repID + '>'
        + ' <i class="fa fa-plus my-float" id="float">'
        + (data.repCurrentStatus == "approved" ? "Unapprove" : "Approve") + '</i>'
        + '  </a>'

        + '<a class="mailIconInsideRep mailIconInsideRep--mail" data-modal-target=".modalOfMail" data-default="mailIcon" data-repID=' + data.repID + '>'
        + ' <i class="fa fa-plus my-float report-mail-floatIcon" id="float">Correspondence</i>'
        + '  </a>'



        + '          </div>'
        + ''
        + '        </div>'



        //EO floatingIcon


        + '<div class="reportsBoxForModal">                                                        '
        + '  <div class="loginCtnTitle">'
        + '    <!--  <h2>IVE Airline</h2> <a class="close" data-close-button></a> -->'
        + '    <h2 class="boxTitle">Complaint</h2>'
        + ''
        + ''
        + '    <img class="closeIcon close" src="./images/exit.png" data-close-button alt="">'
        + '  </div>'
        + ''
        + '  <!--SOF order ______________________________________________________ -->'
        + '  <div class="containerOrderList" id="containerOrderList">'
        + ''
        + ''
        + '    <hr>'
        + '    <!--SOF sideFunction-->'
        + '    <div class="cmtHistory">'
        + ''
        + '      <br>'


        + '      <div class="formTitle postSideFunction"> Status: </div>'
        + '      <ul class="historyOfCmt">'
        + ''

        + ''
        + ''
        + ''
        + ''
        + '      </ul>'
        + '      <br>'
        + ''

        + '      <br>'
        + ''

        + '    </div>'
        + '    <!--EOD sideFunction-->'
        + ''
        + '    <!--SOF postContainer-->'
        + '    <div class="cmtContainer">'
        + '      <div class="complaintBox1" data-repID=' + data.repID + '>'
        + '        <!--SOF comlaint 1 -->'
        + '        <div class="postBox complaint1 active">'
        + ''
        + '          <div class="complaint1_Status">'
        + '            <b>'
        + '              <center class="statusComplaints1">' + data.repCurrentStatus + '</center>'
        + '            </b>'
        + '          </div>'
        + ''
        + '          <!-- SOF topic-post 1 -->'
        + ''
        + '          <div>'
        + '            <!-- SOF title -->'
        + '            <div class="complaint1_title">'
        + data.repTitle
        + '              </b>'
        + '            </div>'


        + '<a href="#" class="float" data-repID=' + data.repID + '>'
        + ' <i class="fa fa-plus my-float" id="float">'
        + (data.repCurrentStatus == "approved" ? "Unapprove" : "Approve") + '</i>'
        + '  </a>'




        + '            <div>'
        + '              <div class="commendBox complaint1 post1 active">'
        + '                <!-- SOF Personal information -->'
        + '                <div class="cmtInfor">'
        + '                  <div class="cmtPersonInof">'
        + '                    <br>'
        + '                    <br>'
        + '                    <table>'
        + ''
        + '                      <tr class="dataTableForCitizen" data-citizenid=' + data.repNormalUser + '>'
        + '                        <td style="width:100px">'
        + '                          <img src="images/pp2.png" width="80" height="80" />'
        + '                        </td>'
        + '                        <td style="font-size:30px">' + data.userName + '</td>'
        + ''
        + '                        <td style="width:300px;">'
        + '                          <span> · </span>'
        + data.repDateSubmit
        + '                        </td>'
        + '                      </tr>'
        + '                    </table>'
        + ''
        + '                  </div>'
        + '                  <!-- SOF Content -->'
        + '                  <div class="postContent">'
        + '                    <br>'
        + '                    <table class="reporterInfoTable">'
        + '                      <tr>'
        + '                        <td>'
        + '                          <b>Nature</b>:'
        + '                          <select class="complaintNature complaintOption" disabled data-attribute="type">'
        + '                            <option   value="Pest Control"'
        + ((type === "Pest Control") == false ? "" : " selected ") + '>Pest Control</option>'
        + '                            <option value="Air Pollution" '
        + ((type === "Air Pollution") == false ? "" : " selected ") + '>Air Pollution </option>'
        + '                            <option value="Noise Pollution"'
        + ((type === "Noise Pollution") == false ? "" : " selected ") + '>Noise Pollution </option>'
        + '                            <option value="Water Pollution"'
        + ((type === "Water Pollution") == false ? "" : " selected ") + '>Water Pollution </option>'
        + '                            <option  value="Waste Pollution"'
        + ((type === "Waste Pollution") == false ? "" : " selected ") + '>Waste Pollution'
        + '                            </option>'


        + '                          </select>'

        + '                          <span class="complaintNature_edit demonHide" contenteditable="true">(Edit)</span>'
        + '                        </td>'
        + '                      </tr>'
        //+otherDescription
        + '<tr>'
        + '                        <td>'
        + '                          <b>Department</b>:'
        + '                          <select class="complaintDept complaintOption" disabled data-attribute="dept">'

        + '                            <option value="Evir. Prot. Dept." '
        + ((repDept === "Evir. Prot. Dept.") == false ? "" : " selected ") + '>Environment Protection Department </option>'
        + '                            <option value="Police Force"'
        + ((repDept === "Police Force") == false ? "" : " selected ") + '>Police Force</option>'
        + '                            <option value="Food and Environmental Hygiene Department"'
        + ((repDept === "Food and Environmental Hygiene Department") == false ? "" : " selected ") + '>Food and Environmental Hygiene Department</option>'
        + '                            <option value="Housing Authority" '
        + ((repDept === "Housing Authority") == false ? " " : " selected ") + '>Housing Authority </option>'

        + '                            <option value="" '
        + ((repDept === "") == false ? " " : " selected ") + '>Unassigned</option>'


        + '                          </select>'
        + '                          <!-- '
        + '                                  <span class="complaintNature" contenteditable="false">Pest Control'
        + '                                    Dust</span>-->'
        + '                          <span class="complaintNature_edit demonHide" contenteditable="true">(Edit)</span>'
        + '                        </td>'
        + '                      </tr>'
        + '                      <tr>'
        + '                        <td> <b>Date</b>:' + data.repDatePeriodBegin + ' </td>'
        + '                      </tr>'
        + '                      <tr>'
        + '                        <td> <b>Location</b>:'
        + data.repLocationDetail
        + '                        </td>'
        + '                      </tr>'
        + '                      <tr>'
        + '                        <td><b>Description</b> :</td>'
        + '                      </tr>'
        + '                    </table>'
        + '                    <br>'
        + ''
        + ''
        + '                    <div>'
        + '                      <span class="repContent">'
        + data.repContent
        + "<br>"




        + '' + (havaAttach === true ?
          ("<div  class='attachTitleBox'><span class='attachTitle'>Attachment:</span>"
            + "<div class='attachPic--report'>"
            + mailAttachment
            + "</div>"
            + "</div>") : "")













        + '                      </span>'
        + '                    </div>'
        + '                  </div>'
        + ''
        + '                </div>'
        + ''
        + '              </div>'
        + ''
        + ''
        + '            </div>'
        + '            <br>'
        + ''
        + '          </div>'
        + '          <hr class="postLine">'
        + '        </div>'
        + '        <!--EOF comlaint 1 -->'

        + '  <!--       <div class="managementFunc demonHide">'
        + '          <span> Management function</span>'
        + '          <div></div>'
        + '          <br>'
        + '          <button class="complaintButton1" data-close-button>Approve</button>'
        + '          <div></div>'
        + '        </div> --->'
        + ''
        + '        <!--SOF Response Box-->'
        + '        <div class="cmtSumbitBox reportStautsUpdatetBox demonHide">'
        + '          <h2>Update Status</h2>'
        + '<div class="submitOptions">'
        + '          <textarea class="cmtBox reportTextArea" placeholder="remark..." rows="20" name="comment[text]" id="comment_text" cols="40"'
        + '            class="ui-autocomplete-input" autocomplete="off" role="textbox" aria-autocomplete="list"'
        + '            aria-haspopup="true"></textarea>'
        + '          <br>'

        + '          <div class="postStatusFunc">'
        + '            <label for="">Status: </label>'
        + '            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;'
        + '            <select name="Status" class="repSubmitStatus" >'

        + '              <option value="Fack Checking">Fack Checking</option>'
        + '              <option value="Wait in line">Wait in line</option>'

        + '              <option value="Solved">Solved</option>'
        + '              <option value="unapproved">reclassfiy</option>'

        + '            </select>'
        + '            <div class="psotUpdateChkbox">'
        + ''
        + ''


        + '<div class="submitNotifyUserBox">'
        + '<input type="checkbox" class="submitNotifyUser" name="options[]" value="option3"      data-rep_street="' + data.repStreet + '"         >Update relevant reports  '
        + '</div>'
        + '            </div>'
        + '          </div>'
        + '          <div class="postSubmitBtn">'
        + '<div>'

















        + '<!--SO reportlBoxFunction-->'





        + '<div class="reportlBoxFunction "> '
        + '<!--  image file and close button-->'
        + '<span class="file-input-Ctn file-input-Ctn-mail demonHide">'

        + '<input type="file"   class="file-input file-input-report" id="file-input-report">'
        + '<span class="file-input-cancel-submit">X</span>'
        + '</span>'


        //S input file
        + ' <div class="mailAttachBox mailAttachBox--specificBox">'
        + '       <input type="file" id="file-input--singleReportAttach" class="fileInput fileInput--singleReportAttach inputDisplay--singleReportAttach file-input-mail-JS 0"   />'
        + '       <div class="preview preview--singleReportAttach"></div>'

        + '   </div>'


        + ' <hr style="width:100%;text-align:left;margin-left:0">'
        //E input file





        + '<!--  button and label and image-->'





        + '<div class="mailBoxFunctionInsideRep">'
        + '            <button class="submitButton sendCmtBtn sendCmtBtnGP2 reportSubmitButton" data-submit_button="reportSubmit" data-submit_box=".reportStautsUpdatetBox" >Submit</button>'



        + ' <div class="uploadForAttach">'

        + '  <label for="file-input--singleReportAttach">'
        + '    <img src="./images/attachIcon.png"/>'
        + ' </label>'

        + '</div>'


        + '</div>'


        + '</div> '

        + '<!--EO mailBoxFunctionInsideRep-->'








































        + '</div>'




















        + '      </div>'
        + '          </div>'
        + ''
        + '        </div>'
        + '        <!--SOF Response Box-->'
        + ''
        + ''
        + ''
        + ''
        + ''
        + ''
        + '      </div>'
        + '      <div class="complaintBox2 demonHide">'
        + '        <!--SOF comlaint 1 -->'
        + '        <div class="postBox complaint1 active">'
        + ''
        + ''
        + ''
        + '          <!-- SOF topic-post 1 -->'
        + '          <div class="complaint1_Status">'
        + '            <b>'
        + '              <center class="statusComplaints1">Wait in line</center>'
        + '            </b>'
        + '          </div>'
        + ''
        + ''
        + ''
        + '          <div>'
        + '            <!-- SOF title -->'
        + '            <div class="complaint1_title">'
        + '              <b>******* 搞到成個垃圾崗咁！'
        + '              </b>'
        + '            </div>'
        + '            <div>'
        + '              <div class="commendBox complaint1 post1 active">'
        + '                <!-- SOF Personal information -->'
        + '                <div class="cmtInfor">'
        + '                  <div class="cmtPersonInof">'
        + '                    <br>'
        + '                    <br>'
        + '                    <table>'
        + ''
        + '                      <tr>'
        + '                        <td style="width:100px">'
        + '                          <img src="images/pp2.png" width="80" height="80" />'
        + '                        </td>'
        + '                        <td style="font-size:30px">陳克勤</td>'
        + ''
        + '                        <td style="width:300px;">'
        + '                          <span> · </span>'
        + '                          Post: 12 Jan 2023'
        + '                        </td>'
        + '                      </tr>'
        + '                    </table>'
        + ''
        + '                  </div>'
        + '                  <!-- SOF Content -->'
        + '                  <div class="postContent">'
        + '                    <br>'
        + '                    <table>'
        + '                      <tr>'
        + '                        <td>'
        + '                          <b>Nature</b>:'
        + '                          <span class="complaintNature" contenteditable="false">Waste Pollution</span>'
        + '                          <span class="complaintNature_edit" contenteditable="true">(Edit)</span>'
        + '                        </td>'
        + '                      </tr>'
        + '                      <tr>'
        + '                        <td> <b>Date</b>: 10 Jan 2023</td>'
        + '                      </tr>'
        + '                      <tr>'
        + '                        <td> <b>Location</b>: 4 Ashley Road, Tsim Sha Tsui'
        + '                        </td>'
        + '                      </tr>'
        + '                      <tr>'
        + '                        <td><b>Description</b> :</td>'
        + '                      </tr>'
        + '                    </table>'
        + '                    <br>'
        + '                    <div>'
        + '                      <span>'
        + '                        construction dust is intolerable here'
        + ''
        + '                        <img src="./images/cdust.jpg" alt="Italian Trulli">'
        + '                      </span>'
        + '                    </div>'
        + '                  </div>'
        + ''
        + '                </div>'
        + ''
        + '              </div>'
        + ''
        + ''
        + '            </div>'
        + '            <br>'
        + ''
        + '          </div>'
        + '          <hr class="postLine">'
        + '        </div>'
        + '        <!--EOF comlaint 1 -->'
        + ''
        + ''
        + '        <!--SOF comlaint 1 -->'
        + '        <div class="postBox complaint2 active ">'
        + ''
        + ''
        + '          <div>'
        + ''
        + ''
        + ''
        + ''
        + '            <br>'
        + ''
        + '          </div>'
        + ''
        + '        </div> <!-- SOF  post 2 -->'
        + ''
        + '        <div class="managementFunc demonHide">'
        + '          <span> Management function</span>'
        + '          <div></div>'
        + '          <br>'
        + '          <button class="complaintButton1" data-close-button>Approve</button>'
        + '          <div></div>'
        + '        </div>'
        + ''
        + '        <!--SOF Response Box-->'
        + '        <div class="cmtSumbitBox"  >'
        + '          <h2>Response</h2>'
        + ''
        + '          <textarea class="cmtBox mailTextArea" placeholder="This is an awesome comment box" rows="20" name="comment[text]"'
        + '            id="comment_text" cols="40" class="ui-autocomplete-input" autocomplete="off" role="textbox"'
        + '            aria-autocomplete="list" aria-haspopup="true"></textarea>'
        + '          <br>'
        + ''
        + '          <div class="postStatusFunc">'
        + '            <label for="">Status: </label>'
        + '            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;'
        + '            <select name="Status" id="">'
        + '              <option value="">Unchange</option>'
        + '              <option value="">Fack Checking</option>'
        + '              <option value="">Wait in line</option>'
        + '              <option value="">Take action</option>'
        + '              <option value="">Solved</option>'
        + '            </select>'
        + '            <div class="psotUpdateChkbox">'
        + '              Update Related Complaints<input type="checkbox">'
        + '            </div>'
        + '          </div>'
        + '          <div class="postSubmitBtn">'
        + '            <button class="sendCmtBtn sendCmtBtnGP2">Submit</button>'
        + '          </div>'
        + ''
        + '        </div>'
        + '        <!--SOF Response Box-->'
        + ''
        + ''
        + ''
        + ''
        + ''
        + ''
        + '      </div>'
        + '    </div>'
        + '    <!--SOF postContainer-->'
        + ''
        + ''
        + ''
        + ''
        + ''
        + ''
        + '  </div>'
        + '  <!-- Table of order ______________________________________________________ -->'
        + ''
        + ''



      return false








    }
  })



















  //  $('.modal').html("")//.append(content)

  $('#modal').html(content)


  modal()
  customizeReport()
  //  $('#modal').append(content)

  insertMailBoxIntoPost();
  getMailRecordsspecific(reportID)

  getReportStatus(reportID)
  /* 
  */


}//EOF GETREPORTS FUNCTION



function customizeReport() {

  if ($.cookie('userDept') != "Operator") {

    $('.cmtSumbitBox').removeClass("demonHide")
    $('.float').addClass("demonHide");

  } else {
    $('.complaintNature_edit').removeClass("demonHide")


  }
}

function addStatusToReports() {

  $.ajax({
    type: 'POST',
    dataType: "json",
    data: {

      isSent: isSent,
      userID: $.cookie('userID')
    },
    async: false,

    url: "./php/getReportStatus.php",
    success: function (result) {
      mailResult = result


      $.each(result, function (index, data) {

        content +=
          '   <div class="mail-list-summary-one  ' + ((data.isSent == 0 && data.isRead == 0) ? "mail-list-summary-one--isRead" : "") + '" '
          + ' data-mailid=' + data.mailId
          + ' data-issent=' + data.isSent
          + ' data-isread=' + data.isRead + '>'
          + '              <div class="mail-list-titleAndcontent">'
          + '                <div class="mail-list-title">' + data.title + '</div>'
          + '                <div class="mail-list-content">' + data.content + '</div>'
          + '              </div>'
          + '              <div class="mail-list-date">' + data.dateCreated
          + '</div>'
          + '            </div>'




      })
      $.each(result, function (index, data) {

        mailLastestOne = data.mailId

        return false;
      })







      $(".mail-record-box-table").append(
        content == "" ? "No any mail" : (content));



      $('.mail-record-box-table').fadeIn(500);
      //  addNoIndex(); 
      //  var table =document.getElementById('mail-record-box-table')
      // getPagination(table);


    }


  })

}
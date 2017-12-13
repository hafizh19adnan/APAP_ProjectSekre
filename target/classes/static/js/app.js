$(document).ready(function() {
    $overthinking = {};
    $overfeeling = [];
	
	$('#example').DataTable();
    
    $('#button-add-jadwal').click(function(){
    	var counter = parseInt($('#counter').text())+1;
    	$('#add-jadwal').append("<br/><h5>Jadwal "+counter+"</h5><hr/><div class='form-group'><label>Hari</label><select	class='form-control' name='hari'><option>Senin</option><option>Selasa</option><option>Rabu</option><option>Kamis</option><option>Jumat</option><option>Sabtu</option></select></div><div class='row'><div class='col-6'><label>Jam Masuk</label><input type='time' name='jam_masuk' required='true' class='form-control'/></div><div class='col-6'><label>Jam Keluar</label><input type='time' name='jam_selesai' required='true' class='form-control'/></div></div>");  
    	$('#counter').text(counter);
    	return false;
    });
    
    $('#button-add-jadwal-create').click(function(){
    	var counter = parseInt($('#counter').text())+1;
    	$('#add-jadwal-create').append("<br/><h5>Jadwal "+counter+"</h5><hr/><div class='form-group'><label>Hari</label><select	class='form-control' name='hari'><option>Senin</option><option>Selasa</option><option>Rabu</option><option>Kamis</option><option>Jumat</option><option>Sabtu</option></select></div><div class='row'><div class='col-6'><label>Jam Masuk</label><input type='time' name='jam_masuk' required='true' class='form-control'/></div><div class='col-6'><label>Jam Keluar</label><input type='time' name='jam_selesai' required='true' class='form-control'/></div></div>");  
    	$('#counter').text(counter);
    	return false;
    });
    
    $('.button-delete-jadwal').click(function(){
//    	if ($overthinking[this.value]) {
//    		delete $overthinking[this.value];
//    		$('#' + this.id).html("- Delete Jadwal");
//    	} else {
//    		$overthinking[this.value] = true;
//    		$('#' + this.id).html("- Undo Delete Jadwal");
//    	}
//    	console.log("Iffah ketawa " + JSON.stringify($overthinking) + " kali");
//    	$('#arr-jadwal').val(JSON.stringify($overthinking));
    	if ($.inArray(this.value, $overfeeling) != -1) {
        	$overfeeling.splice($.inArray(this.value, $overfeeling),1);
    		$('#' + this.id).html("- Delete Jadwal");    		
    	} else {
    		$overfeeling.push(this.value);
    		$('#' + this.id).html("- Undo Delete Jadwal");
    	}
    	console.log($overfeeling);
    	$('#arr-jadwal').val($overfeeling);
    	return false;
    });
} );